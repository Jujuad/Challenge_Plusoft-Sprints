package br.com.fiap.challengePlusoft.service;

import br.com.fiap.challengePlusoft.dto.WebsiteDTO;
import br.com.fiap.challengePlusoft.exception.ResourceNotFoundException;
import br.com.fiap.challengePlusoft.model.Website;
import br.com.fiap.challengePlusoft.repository.WebsiteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebsiteService {

    private final WebsiteRepository websiteRepository;

    public List<Website> listarWebsites() {
        return websiteRepository.findAll();
    }

    public Object buscarWebsitePorId(Long id) {
        return websiteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Website não encontrado com o ID: " + id));
    }

    public Website criarWebsite(@Valid WebsiteDTO websiteDTO) {
        Website website = new Website(websiteDTO);
        return websiteRepository.save(website);
    }

    public Website atualizarWebsite(Long id, WebsiteDTO websiteDTO) {
        Website website = (Website) buscarWebsitePorId(id);

        website.setUrlWebsite(websiteDTO.getUrlWebsite());
        website.setNomeWebsite(websiteDTO.getNomeWebsite());
        website.setDescricaoWebsite(websiteDTO.getDescricaoWebsite());
        website.setIdEmpresa(websiteDTO.getIdEmpresa());
        website.setIdConcorrente(websiteDTO.getIdConcorrente());

        return websiteRepository.save(website);
    }


    public void deletarWebsite(Long id) {
        Website website = (Website) buscarWebsitePorId(id);
        websiteRepository.delete(website);
    }
}

