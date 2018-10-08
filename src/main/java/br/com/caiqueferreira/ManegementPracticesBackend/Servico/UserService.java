package br.com.caiqueferreira.ManegementPracticesBackend.Servico;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.caiqueferreira.ManegementPracticesBackend.Segurança.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}