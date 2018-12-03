package br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao;

public class AuthenticacaoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AuthenticacaoExcecao(String msg) {
		super(msg);
	}
	
	public AuthenticacaoExcecao(String msg, Throwable cause) {
		super(msg, cause);
	}

}
