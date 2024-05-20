package br.com.fiap.challengePlusoft.service;

import br.com.fiap.challengePlusoft.dto.EnderecoDTO;
import br.com.fiap.challengePlusoft.exception.ResourceNotFoundException;
import br.com.fiap.challengePlusoft.model.Endereco;
import br.com.fiap.challengePlusoft.repository.EnderecoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public List<Endereco> listarEnderecoss() {
        return enderecoRepository.findAll();
    }

    public Endereco buscarEnderecoPorId(Long id) {
        return (Endereco) enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço da  não encontrado com o ID: " + id));
    }

    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(Long id, @Valid EnderecoDTO enderecoDTO) {
        Endereco endereco = buscarEnderecoPorId(id);

        endereco.setCepEndereco(enderecoDTO.getCepEndereco());
        endereco.setRuaEndereco(enderecoDTO.getRuaEndereco());
        endereco.setNumEndereco(enderecoDTO.getNumEndereco());
        endereco.setBairroEndereco(enderecoDTO.getBairroEndereco());
        endereco.setCidadeEndereco(enderecoDTO.getCidadeEndereco());
        endereco.setEstadoEndereco(enderecoDTO.getEstadoEndereco());
        endereco.setUfEndereco(enderecoDTO.getUfEndereco());
        endereco.setPaisEndereco(enderecoDTO.getPaisEndereco());

        return enderecoRepository.save(endereco);
    }


    public void deletarEndereco(Long id) {
        Endereco endereco = buscarEnderecoPorId(id);
        enderecoRepository.delete(endereco);
    }
}

