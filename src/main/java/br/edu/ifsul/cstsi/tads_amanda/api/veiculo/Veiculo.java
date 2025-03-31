package br.edu.ifsul.cstsi.tads_amanda.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "veiculos")
public class Veiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private String placa;
    private Date fabricacao;
    @ManyToOne
    @JoinColumn(name = "motorista_id", referencedColumnName = "id", nullable = false)
    private Motorista motorista;


}
