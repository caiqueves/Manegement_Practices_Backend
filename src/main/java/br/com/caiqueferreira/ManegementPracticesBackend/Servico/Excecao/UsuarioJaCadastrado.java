package br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao;

public final class UsuarioJaCadastrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioJaCadastrado() {
        super();
    }

    public UsuarioJaCadastrado(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UsuarioJaCadastrado(final String message) {
        super(message);
    }

    public UsuarioJaCadastrado(final Throwable cause) {
        super(cause);
    }

}