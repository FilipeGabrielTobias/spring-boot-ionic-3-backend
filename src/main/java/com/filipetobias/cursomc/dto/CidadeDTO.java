package com.filipetobias.cursomc.dto;

import com.filipetobias.cursomc.domain.Cidade;
import lombok.Data;

import java.io.Serializable;

@Data
public class CidadeDTO implements Serializable {
    private static  final long serialVersionUID = 1L;

    private Integer id;

    private String nome;

    public CidadeDTO(Cidade obj){
        id = obj.getId();
        nome = obj.getNome();
    }

}
