package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TipoPerfil")
public class TipoPerfil  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
/*	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Login_id")
	private Login login;*/

	private String Descricao;
	
	public TipoPerfil () {}

	public TipoPerfil(Integer id, String descricao) {
		super();
		this.Id = id;
		this.Descricao = descricao;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}


	
	
	
}
