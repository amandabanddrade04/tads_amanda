package br.edu.ifsul.cstsi.tads_amanda.api.motorista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface MotoristaRepository extends JpaRepository<Motorista, Integer> {
}