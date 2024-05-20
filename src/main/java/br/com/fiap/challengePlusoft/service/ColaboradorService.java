package br.com.fiap.challengePlusoft.service;

import br.com.fiap.challengePlusoft.dto.ColaboradorDTO;
import br.com.fiap.challengePlusoft.exception.ResourceNotFoundException;
import br.com.fiap.challengePlusoft.model.Colaborador;
import br.com.fiap.challengePlusoft.repository.ColaboradorRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public List<Colaborador> listarColaboradores() {
        return colaboradorRepository.findAll();
    }

    public Colaborador buscarColaboradorPorId(Long id) {
        return (Colaborador) colaboradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Colaborador não encontrado com o ID: " + id));
    }

    public Colaborador criarColaborador(@Valid ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = new Colaborador(colaboradorDTO);
        return colaboradorRepository.save(colaborador);
    }

    public Colaborador atualizarColaborador(Long id, ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = buscarColaboradorPorId(id);

        colaborador.setIdUsuario(colaboradorDTO.getIdUsuario());
        colaborador.setIdEmpresa(colaboradorDTO.getIdEmpresa());

        return colaboradorRepository.save(colaborador);
    }


    public void deletarColaborador(Long id) {
        Colaborador colaborador = buscarColaboradorPorId(id);
        colaboradorRepository.delete(colaborador);
    }
}

