package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;

public interface EmailServico {
	
	void sendOrderConfirmationEmail(List<String> lstDadosEmail);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Usuario usu, String novaSenha);
	
	
}