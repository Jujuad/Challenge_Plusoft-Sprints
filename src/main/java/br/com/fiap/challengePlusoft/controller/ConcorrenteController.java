package br.com.fiap.challengePlusoft.controller;

import br.com.fiap.challengePlusoft.dto.ConcorrenteDTO;
import br.com.fiap.challengePlusoft.model.Concorrente;
import br.com.fiap.challengePlusoft.service.ConcorrenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/concorrentes")
@RequiredArgsConstructor
public class ConcorrenteController {

    private final ConcorrenteService concorrenteService;

    @GetMapping
    public ResponseEntity<List<Concorrente>> listarConcorrentes() {
        List<Concorrente> concorrentes = concorrenteService.listarConcorrentes();
        return ResponseEntity.ok(concorrentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concorrente> buscarConcorrentePorId(@PathVariable Long id) {
        Concorrente concorrente = concorrenteService.buscarConcorrentePorId(id);
        return ResponseEntity.ok(concorrente);
    }

    @PostMapping
    public ResponseEntity<?> criarConcorrente(@Valid @RequestBody ConcorrenteDTO concorrenteDTO, UriComponentsBuilder uriBuilder) {
        Concorrente concorrente = concorrenteService.criarConcorrente(concorrenteDTO);
        UriComponents uriComponents = uriBuilder.path("/concorrentes/{id}").buildAndExpand(concorrente.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(concorrente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Concorrente> atualizarConcorrente(@PathVariable Long id, @Valid @RequestBody ConcorrenteDTO concorrenteDTO) {
        Concorrente concorrenteAtualizado = concorrenteService.atualizarConcorrente(id, concorrenteDTO);
        return ResponseEntity.ok(concorrenteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConcorrente(@PathVariable Long id) {
        concorrenteService.deletarConcorrente(id);
        return ResponseEntity.noContent().build();
    }
}

