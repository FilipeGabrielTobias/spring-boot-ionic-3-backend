package com.filipetobias.cursomc.dto;

import com.filipetobias.cursomc.domain.Produto;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Filipe.Tobias on 30/07/2018.
 */
@Data
public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDTO(){

    }

    public ProdutoDTO(Produto obj){
        id = obj.getId();
        nome = obj.getNome();
        preco = obj.getPreco();
    }
}
