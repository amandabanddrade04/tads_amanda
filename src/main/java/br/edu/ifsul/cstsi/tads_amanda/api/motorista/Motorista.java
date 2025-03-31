package br.edu.ifsul.cstsi.tads_amanda.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "motoristas")
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
}
