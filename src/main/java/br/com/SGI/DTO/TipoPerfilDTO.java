package br.com.caiqueferreira.ManegementPracticesBackend.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TipoPerfilDTO {
    
	@NotNull
    private Integer Id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String Descricao;
}
