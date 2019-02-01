package com.filipetobias.cursomc.services;

import com.filipetobias.cursomc.domain.Cliente;
import com.filipetobias.cursomc.repositories.ClienteRepository;
import com.filipetobias.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Filipe.Tobias on 07/08/2018.
 */
@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private EmailService emailService;

    private Random random = new Random();

    public void sendNewPassword(String email){

        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null){
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String newPass = newPassword();
        cliente.setPassword(pe.encode(newPass));

        clienteRepository.save(cliente);
        emailService.sendNewPasswordEmail(cliente, newPass);
    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i=0; i<10; i++){
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = random.nextInt(3);
        // gera um digito
        if (opt == 0){
            return (char) (random.nextInt(10) + 48);
        }else if (opt == 1){ // gera letra maiuscula
            return (char) (random.nextInt(26) + 65);
        }else { // gera letra minuscula
            return (char) (random.nextInt(26) + 97);
        }
    }
}
