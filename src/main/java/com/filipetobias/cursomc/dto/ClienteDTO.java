package com.filipetobias.cursomc.dto;

import com.filipetobias.cursomc.domain.Cliente;
import com.filipetobias.cursomc.services.validation.ClienteUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Created by Filipe.Tobias on 24/07/2018.
 */
@Data
@ClienteUpdate
public class ClienteDTO implements Serializable {
    private static  final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    public ClienteDTO(){

    }

    public ClienteDTO(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }
}
