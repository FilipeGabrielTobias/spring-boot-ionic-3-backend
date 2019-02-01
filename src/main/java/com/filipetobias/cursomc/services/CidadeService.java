package com.filipetobias.cursomc.services;

import com.filipetobias.cursomc.domain.Cidade;
import com.filipetobias.cursomc.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<Cidade> findAll(Integer estadoId){
        return repository.findCidades(estadoId);
    }
}
