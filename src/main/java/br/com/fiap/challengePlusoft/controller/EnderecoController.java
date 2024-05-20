package br.com.fiap.challengePlusoft.controller;

import br.com.fiap.challengePlusoft.dto.EnderecoDTO;
import br.com.fiap.challengePlusoft.model.Endereco;
import br.com.fiap.challengePlusoft.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecoss() {
        List<Endereco> enderecos = enderecoService.listarEnderecoss();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Long id) {
        Endereco endereco = enderecoService.buscarEnderecoPorId(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public ResponseEntity<?> criarEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO, UriComponentsBuilder uriBuilder) {
        Endereco endereco = enderecoService.criarEndereco(enderecoDTO);
        UriComponents uriComponents = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @Valid @RequestBody EnderecoDTO enderecoDTO) {
        Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, enderecoDTO);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}

