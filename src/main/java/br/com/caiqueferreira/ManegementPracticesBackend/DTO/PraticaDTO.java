package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;

public class PraticaDTO {

	private Integer id;
	
	
	@NotEmpty(message = "Por favor, informe o etapa. Preenchimento obrigatório !")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String etapa;
	
	@NotEmpty(message = "Por favor, informe o problema. Preenchimento obrigatório !")
	@Length(min = 50, max = 500, message = "O tamanho deve ser entre 50 e 500 caracteres")
	private String problema;
	
	@NotEmpty(message = "Por favor, informe a solução. Preenchimento obrigatório !")
	@Length(min = 50, max = 500, message = "O tamanho deve ser entre 50 e 500 caracteres")
	private String solucao;
	
	@NotEmpty(message = "Por favor, informe a fonte. Preenchimento obrigatório !")
	@Length(min = 50, max = 500, message = "O tamanho deve ser entre 50 e 500 caracteres")
	private String fonte;
	
	Integer tipoMetodologia;

	public PraticaDTO() {
		
	}
	
	public PraticaDTO(Pratica obj) {
		super();
		this.id = obj.getId();
		this.etapa = obj.getEtapa();
		this.problema = obj.getProblema();
		this.solucao = obj.getSolucao();
		this.fonte = obj.getFonte();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public Integer getTipoMetodologia() {
		return tipoMetodologia;
	}

	public void setTipoMetodologia(Integer tipoMetodologia) {
		this.tipoMetodologia = tipoMetodologia;
	}
	
	
}
