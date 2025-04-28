package br.edu.ifsul.cstsi.tads_amanda.api.corrida;

import br.edu.ifsul.cstsi.tads_amanda.api.motorista.Motorista;
import br.edu.ifsul.cstsi.tads_amanda.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Entity
@Table(name = "corridas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
