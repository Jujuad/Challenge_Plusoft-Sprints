package br.com.fiap.challengePlusoft.service;

import br.com.fiap.challengePlusoft.dto.ConcorrenteDTO;
import br.com.fiap.challengePlusoft.exception.ResourceNotFoundException;
import br.com.fiap.challengePlusoft.model.Concorrente;
import br.com.fiap.challengePlusoft.repository.ConcorrenteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcorrenteService {

    private final ConcorrenteRepository concorrenteRepository;

    public List<Concorrente> listarConcorrentes() {
        return concorrenteRepository.findAll();
    }

    public Concorrente buscarConcorrentePorId(Long id) {
        return (Concorrente) concorrenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Concorrente não encontrado com o ID: " + id));
    }

    public Concorrente criarConcorrente(@Valid ConcorrenteDTO concorrenteDTO) {
        Concorrente concorrente = new Concorrente(concorrenteDTO);
        return concorrenteRepository.save(concorrente);
    }

    public Concorrente atualizarConcorrente(Long id, ConcorrenteDTO concorrenteDTO) {
        Concorrente concorrente = buscarConcorrentePorId(id);

        concorrente.setRamoAtuacao(concorrenteDTO.getRamoAtuacao());
        concorrente.setNome(concorrenteDTO.getNomeConcorrente());

        return concorrenteRepository.save(concorrente);
    }


    public void deletarConcorrente(Long id) {
        Concorrente concorrente = buscarConcorrentePorId(id);
        concorrenteRepository.delete(concorrente);
    }
}

