package br.com.caiqueferreira.ManegementPracticesBackend.Servico.Validacoes;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioNovoDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Recurso.Excecao.FieldMessage;

public class UsuarioInserirValidacao implements ConstraintValidator<UsuarioInserir,UsuarioNovoDTO >{

	@Override
	public void initialize(UsuarioInserir ann) {
	}
	
 	@Override
	public boolean isValid(UsuarioNovoDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
 		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}