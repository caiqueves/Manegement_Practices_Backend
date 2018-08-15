package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import java.util.Date;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
//import org.thymeleaf.TemplateEngine;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	//@Autowired
	//private TemplateEngine templateEngine;
	
	/*@Autowired
	private JavaMailSender javaMailSender;*/
	
	@Override
	//public void sendOrderConfirmationEmail(Usuario obj, String senha, String TituloEmail) {
	
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
		sm.setText(lstDadosEmail.get(2) + "\n" + lstDadosEmail.get(3));
		return sm;
	}
	
	/*protected String htmlFromTemplateUsuario(Usuario obj,String senha) {
		Context context = new Context();
		obj.setSenha(senha);
		context.setVariable("Usuario", obj);
		return templateEngine.process("email/confirmacaoCadastroUsuario", context);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Usuario obj) {
		try {
		MimeMessage mm = prepareMimeMessageFromUsuario(obj);
		sendHtmlEmail(mm);
		}catch (MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
	}
	protected MimeMessage prepareMimeMessageFromUsuario(Usuario obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("[Manegement Practices] Confirmação de Cadastro");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateUsuario(obj),true);
		
		return mimeMessage;
	}*/
}