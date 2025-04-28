package br.edu.ifsul.cstsi.tads_amanda.api.corrida;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface CorridaRepository extends JpaRepository<Corrida, Integer> {
}