package br.com.fiap.challengePlusoft.service;

import br.com.fiap.challengePlusoft.dto.EmpresaDTO;
import br.com.fiap.challengePlusoft.exception.ResourceNotFoundException;
import br.com.fiap.challengePlusoft.model.Empresa;
import br.com.fiap.challengePlusoft.repository.EmpresaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public Object buscarEmpresaPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada com o ID: " + id));
    }

    public Empresa criarEmpresa(@Valid EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa(empresaDTO);
        return empresaRepository.save(empresa);
    }

    public Empresa atualizarEmpresa(Long id, EmpresaDTO empresaDTO) {
        Empresa empresa = (Empresa) buscarEmpresaPorId(id);

        empresa.setNome(empresaDTO.getNomeEmpresa());
        empresa.setCnpjEmpresa(empresaDTO.getCnpjEmpresa());
        empresa.setRamoAtuacaoEmpresa(empresaDTO.getRamoAtuacaoEmpresa());
        empresa.setIdEndereco(empresaDTO.getIdEndereco());

        return empresaRepository.save(empresa);
    }


    public void deletarEmpresa(Long id) {
        Empresa empresa = (Empresa) buscarEmpresaPorId(id);
        empresaRepository.delete(empresa);
    }
}

