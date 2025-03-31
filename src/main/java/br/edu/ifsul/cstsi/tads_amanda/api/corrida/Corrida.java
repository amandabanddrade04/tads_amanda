package br.edu.ifsul.cstsi.tads_amanda.model;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "corridas")
public class Corrida {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipodePagamento;
    private String detalhesPagamento;
    private Date dataInicio;
    private double preco;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "motorista_id", referencedColumnName = "id", nullable = false)
    private Motorista motorista;

}
