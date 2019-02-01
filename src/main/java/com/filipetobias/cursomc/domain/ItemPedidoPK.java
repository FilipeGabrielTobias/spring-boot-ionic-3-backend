package com.filipetobias.cursomc.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Filipe.Tobias on 19/07/2018.
 */
@Data
@Embeddable
public class ItemPedidoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "fk_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "fk_produto")
    private Produto produto;
}
