package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pratica")
public class Pratica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String etapa;
	
	private String problema;
	
	private String solucao;
	
	private String fonte;
	
	
	@OneToOne
	@JoinColumn(name = "tipoMetodologia_id")
	private TipoMetodologia tipoMetodologia;

	
	public Pratica(Integer id, String etapa, String problema, String solucao, String fonte,
			TipoMetodologia tipoMetodologia) {
		super();
		this.id = id;
		this.etapa = etapa;
		this.problema = problema;
		this.solucao = solucao;
		this.fonte = fonte;
		this.tipoMetodologia = tipoMetodologia;
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



	public TipoMetodologia getTipoMetodologia() {
		return tipoMetodologia;
	}

	public void setTipoMetodologia(TipoMetodologia tipoMetodologia) {
		this.tipoMetodologia = tipoMetodologia;
	}

}
