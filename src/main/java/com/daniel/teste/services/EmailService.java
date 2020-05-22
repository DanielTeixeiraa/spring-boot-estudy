package com.daniel.teste.services;

import org.springframework.mail.SimpleMailMessage;

import com.daniel.teste.models.Pedido;

public interface EmailService {
	
	 void confirmationEmail(Pedido obj);
	 void sendEmail(SimpleMailMessage msg);

}
