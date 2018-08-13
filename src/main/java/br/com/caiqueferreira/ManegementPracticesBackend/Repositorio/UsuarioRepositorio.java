package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
	
	@Transactional(readOnly=true)
	Usuario findByCpfOuCnpj(String cpfOuCnpj);
}