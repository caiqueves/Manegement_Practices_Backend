package br.com.caiqueferreira.ManegementPracticesBackend.Configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.caiqueferreira.ManegementPracticesBackend.Servico.EmailServico;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.SmtpEmailServico;


@Configuration
@Profile("prod")
public class ProducaoConfiguracao {
	
	@Bean
	public EmailServico emailServico() {
		return  new SmtpEmailServico();
	}
}
