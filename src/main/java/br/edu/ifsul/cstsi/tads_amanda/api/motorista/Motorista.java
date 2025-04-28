package br.edu.ifsul.cstsi.tads_amanda.api.motorista;

import br.edu.ifsul.cstsi.tads_amanda.api.corrida.Corrida;
import br.edu.ifsul.cstsi.tads_amanda.api.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "motoristas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Motorista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String telefone;


    @OneToMany(mappedBy = "motorista", fetch = FetchType.EAGER)
    private Collection<Corrida> corridas;
    @OneToMany(mappedBy = "motorista", fetch = FetchType.EAGER)
    private Collection<Veiculo> veiculos;

    public Motorista(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Motorista(String telefone, String email, String nome) {
        this.telefone = telefone;
        this.email = email;
        this.nome = nome;
    }
}
