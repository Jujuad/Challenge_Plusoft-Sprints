package br.com.fiap.challengePlusoft.controller;

import br.com.fiap.challengePlusoft.dto.ColaboradorDTO;
import br.com.fiap.challengePlusoft.model.Colaborador;
import br.com.fiap.challengePlusoft.service.ColaboradorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> listarColaboradores() {
        List<Colaborador> colaboradores = colaboradorService.listarColaboradores();
        return ResponseEntity.ok(colaboradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarColaboradorPorId(@PathVariable Long id) {
        Colaborador colaborador = colaboradorService.buscarColaboradorPorId(id);
        return ResponseEntity.ok(colaborador);
    }

    @PostMapping
    public ResponseEntity<?> criarColaborador(@Valid @RequestBody ColaboradorDTO colaboradorDTO, UriComponentsBuilder uriBuilder) {
        Colaborador colaborador = colaboradorService.criarColaborador(colaboradorDTO);
        UriComponents uriComponents = uriBuilder.path("/colaboradores/{id}").buildAndExpand(colaborador.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(colaborador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizarColaborador(@PathVariable Long id, @Valid @RequestBody ColaboradorDTO colaboradorDTO) {
        Colaborador colaboradorAtualizado = colaboradorService.atualizarColaborador(id, colaboradorDTO);
        return ResponseEntity.ok(colaboradorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarColaborador(@PathVariable Long id) {
        colaboradorService.deletarColaborador(id);
        return ResponseEntity.noContent().build();
    }
}

