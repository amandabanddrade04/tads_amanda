package br.edu.ifsul.cstsi.tads_amanda.model;

import jakarta.persistence.*;

import java.util.Collection;
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Collection<Corrida> corridas;
}
