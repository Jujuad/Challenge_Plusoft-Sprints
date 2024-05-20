package br.com.fiap.challengePlusoft.model;

import br.com.fiap.challengePlusoft.dto.EnderecoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class Endereco {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 8)
    private String cep;

    @NotBlank
    @Size(max = 200)
    private String rua;

    @NotBlank
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

    @OneToOne(mappedBy = "endereco")
    private Empresa empresa;

    public Endereco(EnderecoDTO enderecoDTO) {
    }

    public void setCepEndereco(Object cepEndereco) {
    }

    public void setRuaEndereco(Object ruaEndereco) {
    }

    public void setNumEndereco(Object numEndereco) {
    }

    public void setBairroEndereco(Object bairroEndereco) {
    }

    public void setCidadeEndereco(Object cidadeEndereco) {
    }

    public void setEstadoEndereco(Object estadoEndereco) {
    }

    public void setUfEndereco(Object ufEndereco) {
    }

    public void setPaisEndereco(Object paisEndereco) {

    }
}

