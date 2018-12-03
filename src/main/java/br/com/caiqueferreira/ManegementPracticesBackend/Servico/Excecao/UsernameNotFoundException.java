package br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao;

public class UsernameNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UsernameNotFoundException(String msg) {
		super(msg);
	}

	public UsernameNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}