package br.com.caiqueferreira.ManegementPracticesBackend.Servico.Validacoes;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.DTO.UsuarioNovoDTO;
import br.com.caiqueferreira.ManegementPracticesBackend.Recurso.Excecao.FieldMessage;
import br.com.caiqueferreira.ManegementPracticesBackend.Repositorio.UsuarioRepositorio;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Validacoes.Utils.BR;

public class UsuarioInserirValidacao implements ConstraintValidator<UsuarioInserir,UsuarioNovoDTO >{

	@Override
	public void initialize(UsuarioInserir ann) {
	}
	
 	@Override
	public boolean isValid(UsuarioNovoDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if ((objDto.getCpfOuCnpj().length() == 11) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}
 		if ((objDto.getCpfOuCnpj().length() == 14) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
 		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}