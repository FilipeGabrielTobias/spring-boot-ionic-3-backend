package com.filipetobias.cursomc.services;

import com.filipetobias.cursomc.domain.Cliente;
import com.filipetobias.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Filipe.Tobias on 03/08/2018.
 */
public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
