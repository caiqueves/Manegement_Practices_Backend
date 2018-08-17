package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	
	void sendOrderConfirmationEmail(List<String> lstDadosEmail);
	
	/*void sendOrderConfirmationEmail1(Usuario obj);*/
	
	void sendEmail(SimpleMailMessage msg);
	
	/*void sendOrderConfirmationHtmlEmail(Usuario obj);
	
	void sendHtmlEmail(MimeMessage msg);*/
}