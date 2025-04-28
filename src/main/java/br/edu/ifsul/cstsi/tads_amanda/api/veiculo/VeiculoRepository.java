package br.edu.ifsul.cstsi.tads_amanda.api.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}