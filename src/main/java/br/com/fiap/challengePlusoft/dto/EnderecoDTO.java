package br.com.fiap.challengePlusoft.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoDTO {
    private Long id;

    @NotBlank
    @Size(max = 8)
    private String cep;

    @NotBlank
    @Size(max = 200)
    private String rua;

    @NotNull
    private Integer numero;

    @NotBlank
    @Size(max = 200)
    private String bairro;

    @NotBlank
    @Size(max = 200)
    private String cidade;

    @NotBlank
    @Size(max = 200)
    private String estado;

    @NotBlank
    @Size(max = 2)
    private String uf;

    @NotBlank
    @Size(max = 10)
    private String pais;

    public Object getCepEndereco() {
        return null;
    }

    public Object getRuaEndereco() {
        return null;
    }

    public Object getNumEndereco() {
        return null;
    }

    public Object getBairroEndereco() {
        return null;
    }

    public Object getCidadeEndereco() {
        return null;
    }

    public Object getEstadoEndereco() {
        return null;
    }

    public Object getUfEndereco() {
        return null;
    }

    public Object getPaisEndereco() {
        return null;
    }
}

