package com.filipetobias.cursomc.services;

import java.util.List;
import java.util.Optional;

import com.filipetobias.cursomc.dto.CategoriaDTO;
import com.filipetobias.cursomc.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.filipetobias.cursomc.domain.Categoria;
import com.filipetobias.cursomc.repositories.CategoriaRepository;
import com.filipetobias.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	// Get Categoria By Id
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	// Insere uma nova categoria
	public Categoria insert(Categoria obj){
		obj.setId(null);
		return repository.save(obj);
	}

	// Realiza um update na categoria
	public Categoria update(Categoria obj){
		Categoria newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	// Exclui a categoria com o Id passado por parametro
	public void delete(Integer id){
		findById(id);
		try {
			repository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possuí produtos");
		}
	}

	// Retorna uma lista com todas as categorias
	public List<Categoria> findAll(){
		return repository.findAll();
	}

	// paginação
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	// Converte Categoria para CategoriaDTO
	public Categoria fromDTO(CategoriaDTO objDto){
		return new Categoria(objDto.getId(), objDto.getNome());
	}

	// Os atributos que poderão ser realizados o update
	private void updateData(Categoria newObj, Categoria obj){
		newObj.setNome(obj.getNome());
	}
}
