package com.filipetobias.cursomc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Filipe.Tobias on 03/08/2018.
 */
@Data
public class CredenciaisDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String password;

    public CredenciaisDTO(){

    }
}
