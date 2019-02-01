package com.filipetobias.cursomc.dto;

import com.filipetobias.cursomc.domain.Estado;
import lombok.Data;

import java.io.Serializable;

@Data
public class EstadoDTO implements Serializable {
    private static  final long serialVersionUID = 1L;

    private Integer id;

    private String nome;

    public EstadoDTO(Estado obj){
        id = obj.getId();
        nome = obj.getNome();
    }
}
