package br.edu.ifsul.cstsi.tads_amanda.api.veiculo;

import br.edu.ifsul.cstsi.tads_amanda.api.motorista.Motorista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "veiculos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
