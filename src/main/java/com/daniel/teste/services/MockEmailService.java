package com.daniel.teste.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.daniel.teste.models.Pedido;

public class MockEmailService extends AbstractEmailService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando");
		LOG.info(msg.toString());
		LOG.info("EMAIL ENVIADO");
		
	}
	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		// TODO Auto-generated method stub
		
	}

}
