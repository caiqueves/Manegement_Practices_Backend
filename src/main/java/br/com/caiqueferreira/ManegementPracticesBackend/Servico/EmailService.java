package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;

public interface EmailService {
	
	//void sendOrderConfirmationEmail(Usuario obj, String senha,String TituloEmail);
	
	void sendOrderConfirmationEmail(List<String> lstDadosEmail);
	
	void sendEmail(SimpleMailMessage msg);
	
	/*void sendOrderConfirmationHtmlEmail(Usuario obj);
	
	void sendHtmlEmail(MimeMessage msg);*/
}