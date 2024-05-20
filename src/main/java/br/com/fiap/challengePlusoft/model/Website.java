package br.com.fiap.challengePlusoft.model;

import br.com.fiap.challengePlusoft.dto.WebsiteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Website {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String url;

    @NotBlank
    @Size(max = 200)
    private String nome;

    @Size(max = 200)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "concorrente_id")
    private Concorrente concorrente;

    public Website(WebsiteDTO websiteDTO) {
    }

    public void setUrlWebsite(Object urlWebsite) {
    }

    public void setNomeWebsite(Object nomeWebsite) {
    }

    public void setDescricaoWebsite(Object descricaoWebsite) {
    }

    public void setIdEmpresa(Long idEmpresa) {
    }

    public void setIdConcorrente(Long idConcorrente) {
    }
}

