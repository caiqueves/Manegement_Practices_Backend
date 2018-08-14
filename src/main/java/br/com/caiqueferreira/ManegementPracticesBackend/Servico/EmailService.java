package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import org.springframework.mail.SimpleMailMessage;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;

public interface EmailService {
	void sendOrderConfirmationEmail(Usuario obj);

	void sendEmail(SimpleMailMessage msg);
}