package com.filipetobias.cursomc.services.validation;

import com.filipetobias.cursomc.domain.Cliente;
import com.filipetobias.cursomc.domain.enums.TipoCliente;
import com.filipetobias.cursomc.dto.ClienteDTO;
import com.filipetobias.cursomc.dto.ClienteNewDTO;
import com.filipetobias.cursomc.repositories.ClienteRepository;
import com.filipetobias.cursomc.resources.exception.FieldMessage;
import com.filipetobias.cursomc.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Filipe.Tobias on 26/07/2018.
 */
public class ClientUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClienteRepository repository;

    @Override
    public void initialize(ClienteUpdate ann) {

    }

    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Cliente existEmail = repository.findByEmail(objDto.getEmail());
        if (existEmail != null && !existEmail.getId().equals(uriId)){
            list.add(new FieldMessage("email", "Email já Existente"));
        }

        for (FieldMessage e : list){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
