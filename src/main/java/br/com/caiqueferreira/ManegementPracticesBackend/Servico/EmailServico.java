package br.com.caiqueferreira.ManegementPracticesBackend.Servico;


import org.springframework.mail.SimpleMailMessage;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;

public interface EmailServico {


	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Usuario usuario, String newPass);
}