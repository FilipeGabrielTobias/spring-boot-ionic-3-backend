package com.filipetobias.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.filipetobias.cursomc.domain.enums.EstadoPagamento;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

/**
 * Created by Filipe.Tobias on 18/07/2018.
 */
@Data
@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao(){

    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
