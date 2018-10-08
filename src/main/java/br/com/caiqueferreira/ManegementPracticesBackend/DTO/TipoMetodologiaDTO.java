package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.TipoMetodologia;

public class TipoMetodologiaDTO {

	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 100, message = "O tamanho deve ser entre 5 e 100 caracteres")
	private String descricao;

	
	
	public TipoMetodologiaDTO() {	
	}

	public TipoMetodologiaDTO(TipoMetodologia obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
	}

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
