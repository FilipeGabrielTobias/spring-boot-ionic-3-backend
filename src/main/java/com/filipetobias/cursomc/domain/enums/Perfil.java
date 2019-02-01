package com.filipetobias.cursomc.domain.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Created by Filipe.Tobias on 03/08/2018.
 */
public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");

    @Getter
    private int cod;

    @Getter
    private String descricao;

    private Perfil(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static Perfil toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (Perfil x : Perfil.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
