package br.com.caiqueferreira.ManegementPracticesBackend.Dominio;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notificacao" )
public class Notificacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=false, updatable=false)
	private String Id;
	
	
	private String Descricao;
	
	
}
