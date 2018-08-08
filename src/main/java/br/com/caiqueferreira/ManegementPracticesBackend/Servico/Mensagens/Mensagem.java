package br.com.caiqueferreira.ManegementPracticesBackend.Servico.Mensagens;


public class Mensagem extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public Mensagem(String msg) {
		super(msg);
	}

	public Mensagem(String msg, Throwable cause) {
		super(msg, cause);
	}
}

