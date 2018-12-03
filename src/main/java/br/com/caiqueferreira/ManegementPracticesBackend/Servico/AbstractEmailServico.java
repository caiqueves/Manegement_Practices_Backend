package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.Date;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;

public abstract class AbstractEmailServico implements EmailServico {
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(List<String>lstDadosEmail) {
	    
		SimpleMailMessage sm = prepareSimpleMailMessageFromUsuario(lstDadosEmail);
		sendEmail(sm);
	}
	
	protected SimpleMailMessage prepareSimpleMailMessageFromUsuario(List<String>lstDadosEmail) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(lstDadosEmail.get(2));
		sm.setFrom(sender);
		sm.setSubject("[Project Notification] " + lstDadosEmail.get(0));
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("\nOlá,"  + lstDadosEmail.get(1).toUpperCase() +", "+ lstDadosEmail.get(4) 
		+"\n\n" + lstDadosEmail.get(5) 
		+ "\n\n    Email: " + lstDadosEmail.get(2).toUpperCase() 
		+ "\n    Senha: " + lstDadosEmail.get(3).toUpperCase() 
		+"\n\nCaso não tenha conhecimento dessa solicitação, pedimos que desconsidere o e-mail."
        +"\n\nAtt \nEquipe do APP Project Notification");
		return sm;
	}
	
	public void sendNewPasswordEmail(Usuario obj, String novaSenha) {
		
		SimpleMailMessage sm = prepareNewPasswordEmail(obj, novaSenha);
		sendEmail(sm);
	}

	private SimpleMailMessage prepareNewPasswordEmail(Usuario obj, String novaSenha) {
		
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("[Project Notification] Solicitação de Nova Senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("\nOlá,"  + obj.getNome().toUpperCase()  
		+ "!\nSegue sua nova senha de acesso ao aplicativo Project Notification." 
		+ "\n\nSenha: " +novaSenha 
		+"\n\nCaso não tenha conhecimento dessa solicitação, pedimos que desconsidere o e-mail."
        +"\n\nAtt \nEquipe do APP Project Notification");
		return sm;
	}
	
	
	
}