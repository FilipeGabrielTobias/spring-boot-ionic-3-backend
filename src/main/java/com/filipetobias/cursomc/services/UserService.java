package com.filipetobias.cursomc.services;

import com.filipetobias.cursomc.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Filipe.Tobias on 06/08/2018.
 */
public class UserService {

    public static UserSS authenticated(){
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch(Exception e) {
            return null;
        }
    }
}
