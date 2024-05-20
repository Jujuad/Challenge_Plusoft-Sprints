package br.com.fiap.challengePlusoft.controller;

import br.com.fiap.challengePlusoft.dto.AnaliseDTO;
import br.com.fiap.challengePlusoft.model.Analise;
import br.com.fiap.challengePlusoft.service.AnaliseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/analises")
@RequiredArgsConstructor
public class AnaliseController {

    private final AnaliseService analiseService;

    @GetMapping
    public ResponseEntity<List<Analise>> listarAnalises() {
        List<Analise> analises = analiseService.listarAnalises();
        return ResponseEntity.ok(analises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analise> buscarAnalisePorId(@PathVariable Long id) {
        Analise analise = analiseService.buscarAnalisePorId(id);
        return ResponseEntity.ok(analise);
    }

    @PostMapping
    public ResponseEntity<?> criarAnalise(@Valid @RequestBody AnaliseDTO analiseDTO, UriComponentsBuilder uriBuilder) {
        Analise analise = analiseService.criarAnalise(analiseDTO);
        UriComponents uriComponents = uriBuilder.path("/analises/{id}").buildAndExpand(analise.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(analise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Analise> atualizarAnalise(@PathVariable Long id, @Valid @RequestBody AnaliseDTO analiseDTO) {
        Analise analiseAtualizada = analiseService.atualizarAnalise(id, analiseDTO);
        return ResponseEntity.ok(analiseAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnalise(@PathVariable Long id) {
        analiseService.deletarAnalise(id);
        return ResponseEntity.noContent().build();
    }
}

