package br.edu.ifsul.cstsi.tads_amanda.api.motorista;

public record MotoristaDTOResponse(
        int id,
        String nome,
        String email,
        String telefone
) {
    public MotoristaDTOResponse(Motorista motorista) {
        this(motorista.getId(), motorista.getNome(), motorista.getEmail(), motorista.getTelefone());
    }
}
