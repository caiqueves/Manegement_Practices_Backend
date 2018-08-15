package br.com.caiqueferreira.ManegementPracticesBackend.Configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.caiqueferreira.ManegementPracticesBackend.Servico.EmailService;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.MockEmailService;

@Configuration
@Profile("desenH2")
public class TesteConfiguracao {

	@Bean
	public EmailService emailService() {
		return  new MockEmailService();
	}
}
