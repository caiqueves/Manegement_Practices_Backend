package br.com.caiqueferreira.ManegementPracticesBackend.Configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.caiqueferreira.ManegementPracticesBackend.Servico.EmailService;

import br.com.caiqueferreira.ManegementPracticesBackend.Servico.SmtpEmailService;

@Configuration
@Profile("desen")
public class DesenvolvimentoConfiguracao {

	/*
	 * @Bean public boolean instantiateDatabase() throws ParseException {
	 * dbService.instantiateTestDatabase(); return true; }
	 */
	@Bean
	public EmailService emailService() {
		return  new SmtpEmailService();
	}
}