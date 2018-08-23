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
	
	/*@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;*/
	
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
		sm.setText("Email:" + lstDadosEmail.get(2) + "\n" + lstDadosEmail.get(3));
		return sm;
	}
	
	/*@Override
	public void sendOrderConfirmationEmail1(Usuario obj) {
	    
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido1(obj);
		sendEmail(sm);
	}
	
	protected SimpleMailMessage prepareSimpleMailMessageFromPedido1(Usuario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	protected String htmlFromTemplateUsuario(Usuario obj) {
		Context context = new Context();
		context.setVariable("Usuario", obj);
		return templateEngine.process("email/confirmacaoCadastroUsuario", context);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Usuario obj) {
		try {
		MimeMessage mm = prepareMimeMessageFromUsuario(obj);
		sendHtmlEmail(mm);
		}catch (MessagingException e) {
			sendOrderConfirmationEmail1(obj);
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
		sm.setText("NovaSenha: " + novaSenha);
		return sm;
	}
}