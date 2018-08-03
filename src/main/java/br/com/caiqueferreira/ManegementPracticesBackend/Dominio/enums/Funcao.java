package br.com.caiqueferreira.ManegementPracticesBackend.Dominio.enums;

public enum Funcao {

	GERENTE(1, "GERENTE"), ANALISTA(2, "ANALISTA");
    
	private int cod;
	private String descricao;

	private Funcao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Funcao toEnum(Integer integer) {

		if (integer == null) {
			return null;
		}

		for (Funcao x : Funcao.values()) {
			if (integer.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + integer);
	}
}
