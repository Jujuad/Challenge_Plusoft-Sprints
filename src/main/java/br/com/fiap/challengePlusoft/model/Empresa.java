package br.com.fiap.challengePlusoft.model;

import br.com.fiap.challengePlusoft.dto.EmpresaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Empresa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String nome;

    @NotBlank
    @Size(max = 14)
    private String cnpj;

    @NotBlank
    @Size(max = 200)
    private String ramoAtuacao;

    @OneToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "empresa")
    private List<Colaborador> colaboradores;

    @OneToMany(mappedBy = "empresa")
    private List<Website> websites;

    public Empresa(EmpresaDTO empresaDTO) {
    }
    public void setCnpjEmpresa(Object cnpjEmpresa) {
    }

    public void setRamoAtuacaoEmpresa(Object ramoAtuacaoEmpresa) {
    }

    public void setIdEndereco(Long idEndereco) {

    }
}

