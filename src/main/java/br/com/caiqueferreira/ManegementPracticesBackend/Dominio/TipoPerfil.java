package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

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
	
	@OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="usuario_perfil",  
              joinColumns={@JoinColumn(name="perfil_id", 
               referencedColumnName="id")},  
              inverseJoinColumns={@JoinColumn(name="usuario_id", 
                referencedColumnName="id")}) 
	
	private List<Usuario> usuarios;

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
