package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Notificacao" )
public class Notificacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String Descricao;
	
	/*@OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="TipoNotificacao_Notificacao",
              joinColumns={@JoinColumn(name="notificacao_id",  
               referencedColumnName="id")},  
              inverseJoinColumns={@JoinColumn(name="TipoNotificacao_id",   
               referencedColumnName="id")}) 
	
	private TipoNotificacao tipoNotificacao;*/
    
	public Notificacao() {
		
	}
	
	public Notificacao(Long id, String descricao) {
		super();
		Id = id;
		Descricao = descricao;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	/*public TipoNotificacao getTipoNotificacao() {
		return tipoNotificacao;
	}

	public void setTipoNotificacao(TipoNotificacao tipoNotificacao) {
		this.tipoNotificacao = tipoNotificacao;
	}
    */
	
    
	
	   
}
