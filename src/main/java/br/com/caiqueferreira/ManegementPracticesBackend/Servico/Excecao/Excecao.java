package br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao;

public class Excecao extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public Excecao(String msg) {
		super(msg);
	}

	public Excecao(String msg, Throwable cause) {
		super(msg, cause);
	}

}

