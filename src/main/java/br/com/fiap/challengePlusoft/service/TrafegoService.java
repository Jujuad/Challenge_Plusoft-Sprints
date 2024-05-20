package br.com.fiap.challengePlusoft.service;

import br.com.fiap.challengePlusoft.dto.TrafegoDTO;
import br.com.fiap.challengePlusoft.exception.ResourceNotFoundException;
import br.com.fiap.challengePlusoft.model.Trafego;
import br.com.fiap.challengePlusoft.repository.TrafegoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrafegoService {

    private final TrafegoRepository trafegoRepository;

    public List<Trafego> listarTrafegos() {
        return trafegoRepository.findAll();
    }

    public Trafego buscarTrafegoPorId(Long id) {
        return (Trafego) trafegoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tráfego não encontrado com o ID: " + id));
    }

    public Trafego criarTrafego(TrafegoDTO trafegoDTO) {
        Trafego trafego = new Trafego(trafegoDTO);
        return trafegoRepository.save(trafego);
    }

    public Trafego atualizarTrafego(Long id, TrafegoDTO trafegoDTO) {
        Trafego trafego = buscarTrafegoPorId(id);

        trafego.setNumVisitantes(trafegoDTO.getNumVisitantes());
        trafego.setTempoMedioVisitaSite(trafegoDTO.getTempoMedioVisitaSite());
        trafego.setIdWebsite(trafegoDTO.getIdWebsite());

        return trafegoRepository.save(trafego);
    }


    public void deletarTrafego(Long id) {
        Trafego trafego = buscarTrafegoPorId(id);
        trafegoRepository.delete(trafego);
    }
}

