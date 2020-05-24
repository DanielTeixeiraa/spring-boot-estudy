package com.daniel.teste.services;

import org.springframework.mail.SimpleMailMessage;

import com.daniel.teste.models.Cliente;
import com.daniel.teste.models.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

	void sendNewPasswordEmail(Cliente cliente, String newPass);
}