package br.edu.ifsul.cstsi.tads_amanda.api.motorista;

import java.io.Serializable;

/**
 * DTO for {@link Motorista}
 */
public record MotoristaDto(String nome, String email, String telefone) implements Serializable {

    public MotoristaDto(Motorista motorista) {
        this(motorista.getNome(), motorista.getEmail(), motorista.getTelefone());
    }
}