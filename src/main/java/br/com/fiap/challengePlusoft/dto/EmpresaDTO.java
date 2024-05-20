package br.com.fiap.challengePlusoft.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class EmpresaDTO {
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

    private Long idEndereco;

    public String getNomeEmpresa() {
        return "";
    }

    public Object getCnpjEmpresa() {
        return null;
    }

    public Object getRamoAtuacaoEmpresa() {
        return null;
    }
}

