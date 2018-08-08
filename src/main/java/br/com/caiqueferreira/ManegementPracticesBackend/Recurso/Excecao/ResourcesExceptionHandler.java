package br.com.caiqueferreira.ManegementPracticesBackend.Recurso.Excecao;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.AuthorizationException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.DataIntegrityException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.Excecao;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Excecao.ObjectNotFoundException;
import br.com.caiqueferreira.ManegementPracticesBackend.Servico.Mensagens.Mensagem;


@ControllerAdvice
public class ResourcesExceptionHandler {
    
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StantardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
	 
    	StantardError err = new StantardError(HttpStatus.NOT_FOUND.value(),e.getMessage(), System.currentTimeMillis());
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
   }
   
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StantardError> dataIntegrity(ObjectNotFoundException e, HttpServletRequest request) {
	 
      StantardError err = new StantardError(HttpStatus.BAD_REQUEST.value(),e.getMessage(), System.currentTimeMillis());
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
   }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StantardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
	  
      ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Erro de validação", System.currentTimeMillis());
      for (FieldError x : e.getBindingResult().getFieldErrors()) {
    	  err.addError(x.getField(),x.getDefaultMessage());
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
   }
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StantardError> authorizationException(AuthorizationException e, HttpServletRequest request) {
	 
      StantardError err = new StantardError(HttpStatus.FORBIDDEN.value(),e.getMessage(), System.currentTimeMillis());
	  return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
   }
	
	@ExceptionHandler(Excecao.class)
	public ResponseEntity<StantardError> excecao(Excecao e, HttpServletRequest request) {
	 
      StantardError err = new StantardError(HttpStatus.BAD_REQUEST.value(),e.getMessage(), System.currentTimeMillis());
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
   }
	
	@ExceptionHandler(Mensagem.class)
	public ResponseEntity<StantardError> excecao(Mensagem e, HttpServletRequest request) {
	 
      StantardError err = new StantardError(HttpStatus.NO_CONTENT.value(),e.getMessage(), System.currentTimeMillis());
	  return ResponseEntity.status(HttpStatus.NO_CONTENT).body(err);
   }
}
