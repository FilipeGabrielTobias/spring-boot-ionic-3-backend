package com.filipetobias.cursomc.resources;

import com.filipetobias.cursomc.domain.Cidade;
import com.filipetobias.cursomc.domain.Estado;
import com.filipetobias.cursomc.dto.CidadeDTO;
import com.filipetobias.cursomc.dto.EstadoDTO;
import com.filipetobias.cursomc.services.CidadeService;
import com.filipetobias.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    private EstadoService service;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> findAll(){
        List<Estado> list = service.findAll();
        List<EstadoDTO> listDTO = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{estadoId}/cidades")
    public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId){
        List<Cidade> listCidades = cidadeService.findAll(estadoId);
        List<CidadeDTO> listCidadesDTO = listCidades.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listCidadesDTO);
    }

}
