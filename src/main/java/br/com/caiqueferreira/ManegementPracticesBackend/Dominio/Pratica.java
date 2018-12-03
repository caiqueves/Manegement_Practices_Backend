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
	private String descricao;

	
	@OneToOne
	@JoinColumn(name = "tipoMetodologia_id")
	private TipoMetodologia tipoMetodologia;

	public Pratica() {

	}

	public Pratica(Integer id, String descricao, TipoMetodologia tipoMetodologia) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tipoMetodologia = tipoMetodologia;
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

	public TipoMetodologia getTipoMetodologia() {
		return tipoMetodologia;
	}

	public void setTipoMetodologia(TipoMetodologia tipoMetodologia) {
		this.tipoMetodologia = tipoMetodologia;
	}

}
