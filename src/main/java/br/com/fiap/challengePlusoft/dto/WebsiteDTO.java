package br.com.fiap.challengePlusoft.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class WebsiteDTO {
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String url;

    @NotBlank
    @Size(max = 200)
    private String nome;

    @Size(max = 200)
    private String descricao;

    @NotNull
    private Long idEmpresa;

    private Long idConcorrente;

    public Object getUrlWebsite() {
        return null;
    }

    public Object getNomeWebsite() {
        return null;
    }

    public Object getDescricaoWebsite() {
        return null;
    }
}

