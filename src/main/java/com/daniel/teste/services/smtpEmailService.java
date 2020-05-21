package com.daniel.teste.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class smtpEmailService extends AbstractEmailService {
	@Autowired
	private static final Logger LOG = LoggerFactory.getLogger(smtpEmailService.class);
	@Autowired
	private MailSender mailSender;
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		//LOG.info("Simulando");
		mailSender.send(msg);
	//	LOG.info("EMAIL ENVIADO");
	}

}
