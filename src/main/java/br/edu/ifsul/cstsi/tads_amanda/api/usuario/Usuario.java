package br.edu.ifsul.cstsi.tads_amanda.api.usuario;

import br.edu.ifsul.cstsi.tads_amanda.api.corrida.Corrida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Collection<Corrida> corridas;


}
