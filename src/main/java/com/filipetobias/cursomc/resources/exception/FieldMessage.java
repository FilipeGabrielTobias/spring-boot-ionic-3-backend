package com.filipetobias.cursomc.resources.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Filipe.Tobias on 24/07/2018.
 */
@Data
public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

    public FieldMessage(){

    }

    public FieldMessage(String fieldName, String message){
        super();
        this.fieldName = fieldName;
        this.message = message;
    }
}
