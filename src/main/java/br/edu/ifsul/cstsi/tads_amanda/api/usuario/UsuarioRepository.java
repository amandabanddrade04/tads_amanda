package br.edu.ifsul.cstsi.tads_amanda.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  }