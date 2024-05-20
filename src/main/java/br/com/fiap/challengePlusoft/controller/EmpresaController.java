package br.com.fiap.challengePlusoft.controller;

import br.com.fiap.challengePlusoft.dto.EmpresaDTO;
import br.com.fiap.challengePlusoft.model.Empresa;
import br.com.fiap.challengePlusoft.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        List<Empresa> empresas = empresaService.listarEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarEmpresaPorId(@PathVariable Long id) {
        Empresa empresa = (Empresa) empresaService.buscarEmpresaPorId(id);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping
    public ResponseEntity<?> criarEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO, UriComponentsBuilder uriBuilder) {
        Empresa empresa = empresaService.criarEmpresa(empresaDTO);
        UriComponents uriComponents = uriBuilder.path("/empresas/{id}").buildAndExpand(empresa.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long id, @Valid @RequestBody EmpresaDTO empresaDTO) {
        Empresa empresaAtualizada = empresaService.atualizarEmpresa(id, empresaDTO);
        return ResponseEntity.ok(empresaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        empresaService.deletarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}

