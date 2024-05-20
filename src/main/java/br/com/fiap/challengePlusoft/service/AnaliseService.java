package br.com.fiap.challengePlusoft.service;

import br.com.fiap.challengePlusoft.dto.AnaliseDTO;
import br.com.fiap.challengePlusoft.exception.ResourceNotFoundException;
import br.com.fiap.challengePlusoft.model.Analise;
import br.com.fiap.challengePlusoft.repository.AnaliseRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnaliseService {

    private final AnaliseRepository analiseRepository;

    public List<Analise> listarAnalises() {
        return analiseRepository.findAll();
    }

    public Analise buscarAnalisePorId(Long id) {
        return (Analise) analiseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Análise não encontrada com o ID: " + id));
    }

    public Analise criarAnalise(AnaliseDTO analiseDTO) {
        Analise analise = new Analise(analiseDTO);
        return analiseRepository.save(analise);
    }

    public Analise atualizarAnalise(Long id, @Valid AnaliseDTO analiseDTO) {
        Analise analise = buscarAnalisePorId(id);

        analise.setResultadosAnalise(analiseDTO.getResultadosAnalise());
        analise.setDataAnalise(analiseDTO.getDataAnalise());
        analise.setIdTrafego(analiseDTO.getIdTrafego());

        return analiseRepository.save(analise);
    }


    public void deletarAnalise(Long id) {
        Analise analise = buscarAnalisePorId(id);
        analiseRepository.delete(analise);
    }
}

