package com.daniel.teste.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.daniel.teste.models.Pedido;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String from;

	@Override
	public void confirmationEmail(Pedido obj) {
		SimpleMailMessage sm = simpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage simpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(from);
		sm.setSubject("Pedido confiramdo");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

	
}
