package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class TipoMetodologiaNovaDTO {

	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 100, message = "O tamanho deve ser entre 5 e 100 caracteres")
	private String descricao;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
