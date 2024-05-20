package br.com.fiap.challengePlusoft.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ConcorrenteDTO {
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String nome;

    @Size(max = 200)
    private String ramoAtuacao;

    public String getNomeConcorrente() {
        return null;
    }
}

