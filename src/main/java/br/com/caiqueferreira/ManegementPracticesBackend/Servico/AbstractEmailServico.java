package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

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
		sm.setSubject("[Manegement Practices] " + lstDadosEmail.get(0));
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Olá,"  + lstDadosEmail.get(1).toUpperCase()  + "!\n\n" + lstDadosEmail.get(4) + "\n Email:" + lstDadosEmail.get(2) + "\n" + lstDadosEmail.get(3)
		          +"\n\n Att \n Manegement Practices");
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
		sm.setSubject("[Manegement Practices] Solicitação de Nova Senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Olá,"  + obj.getNome().toUpperCase()  + "!\n\n Segue sua nova senha: " +  novaSenha.toUpperCase()
        +"\n\n Att \n Manegement Practices");
		return sm;
	}
	
	
	
}