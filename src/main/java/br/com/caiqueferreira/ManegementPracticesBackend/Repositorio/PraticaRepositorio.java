package br.com.caiqueferreira.ManegementPracticesBackend.Repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caiqueferreira.ManegementPracticesBackend.Dominio.Pratica;


@Repository
public interface PraticaRepositorio extends JpaRepository<Pratica, Integer> {

}