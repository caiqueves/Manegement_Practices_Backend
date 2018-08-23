package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailServico extends AbstractEmailServico {

	@Autowired
	private MailSender mailSender;
	
	/*@Autowired
	private JavaMailSender javaMailSender;*/
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailServico.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Enviando email...");
		mailSender.send(msg);
		LOG.info("Email enviado");
	}

	/*@Override
	public void sendHtmlEmail(MimeMessage msg) {
			LOG.info("Enviando email...");
			javaMailSender.send(msg);
			LOG.info("Email enviado");
		}*/
}