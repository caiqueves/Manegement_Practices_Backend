package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TipoPerfil")
public class TipoPerfil  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(insertable=false, updatable=false)
	private Integer Id;
	
	//@ManyToOne
	//@JoinColumn(name="TipoPerfil_id")
	private Login login;
	
	private String Descricao;
	
	public TipoPerfil () {}

	public TipoPerfil(Integer id, String descricao) {
		super();
		Id = id;
		Descricao = descricao;
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
