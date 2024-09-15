package br.com.fiap.challengePlusoft.controller;

import br.com.fiap.challengePlusoft.dto.WebsiteDTO;
import br.com.fiap.challengePlusoft.model.Website;
import br.com.fiap.challengePlusoft.service.WebsiteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/websites")
@RequiredArgsConstructor
public class WebsiteController {

    private final WebsiteService websiteService;

    @GetMapping
    public ResponseEntity<List<Website>> listarWebsites() {
        List<Website> websites = websiteService.listarWebsites();
        return ResponseEntity.ok(websites);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Website> buscarWebsitePorId(@PathVariable Long id) {
        Website website = (Website) websiteService.buscarWebsitePorId(id);
        return ResponseEntity.ok(website);
    }

    @PostMapping
    public ResponseEntity<?> criarWebsite(@Valid @RequestBody WebsiteDTO websiteDTO, UriComponentsBuilder uriBuilder) {
        Website website = websiteService.criarWebsite(websiteDTO);
        UriComponents uriComponents = uriBuilder.path("/websites/{id}").buildAndExpand(website.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(website);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Website> atualizarWebsite(@PathVariable Long id, @Valid @RequestBody WebsiteDTO websiteDTO) {
        Website websiteAtualizado = websiteService.atualizarWebsite(id, websiteDTO);
        return ResponseEntity.ok(websiteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarWebsite(@PathVariable Long id) {
        websiteService.deletarWebsite(id);
        return ResponseEntity.noContent().build();
    }
}

