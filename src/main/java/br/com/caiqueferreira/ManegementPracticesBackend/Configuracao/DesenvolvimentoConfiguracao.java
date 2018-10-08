package br.com.caiqueferreira.ManegementPracticesBackend.Configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.caiqueferreira.ManegementPracticesBackend.Servico.EmailServico;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.SmtpEmailServico;

@Configuration
@Profile("desen")
public class DesenvolvimentoConfiguracao {

	@Bean
	public EmailServico emailService() {
		return  new SmtpEmailServico();
	}
}