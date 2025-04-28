package br.edu.ifsul.cstsi.tads_amanda.api.motorista;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/motoristas")
public class MotoristaController {

    private final MotoristaRepository motoristaRepository;

    public MotoristaController(MotoristaRepository motoristaRepository){
        this.motoristaRepository = motoristaRepository;
    }

    @GetMapping
    public ResponseEntity<List<MotoristaDTOResponse>> getMotoristas() {
        var motoristas = motoristaRepository.findAll();
                return ResponseEntity
                        .ok()
                        .body(
                                motoristas.stream()
                                        .map(m ->
                                                new MotoristaDTOResponse(
                                                        m.getId(),
                                                        m.getNome(),
                                                        m.getEmail(),
                                                        m.getTelefone())).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<Motorista> getMotoristaById(@PathVariable("id") Integer id) {
        var motorista = motoristaRepository.findById(id);
        return motorista.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(motorista.get());
    }

    @GetMapping("nome/{nome}")
    public String getMotoristaByNome(@PathVariable("nome") String nome) {
        return "Motorista com nome: " + nome;
    }

    @PostMapping
    public ResponseEntity<URI> insert(@RequestBody MotoristaDto motoristaDto, UriComponentsBuilder uriBuilder) {
        var m = motoristaRepository.save(new Motorista(
                motoristaDto.nome(),
                motoristaDto.email(),
                motoristaDto.telefone()
        ));
        var location = uriBuilder.path("/api/motoristas/{id}").buildAndExpand(m.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<MotoristaDTOResponse> update(@PathVariable("id") Integer id, @RequestBody MotoristaDto motoristaDto) {
        var optional = motoristaRepository.findById(id);
        if (optional.isPresent()) {
            var m = motoristaRepository.save(new Motorista(
                    id,
                    motoristaDto.nome(),
                    motoristaDto.email(),
                    motoristaDto.telefone()
            ));
            return ResponseEntity.ok(new MotoristaDTOResponse(m));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MotoristaDTOResponse> delete(@PathVariable("id") Integer id) {
        var optional = motoristaRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new MotoristaDTOResponse(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

}