package br.com.fiap.challengePlusoft.model;

import br.com.fiap.challengePlusoft.dto.ConcorrenteDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.List;

@Entity
@Data
public class Concorrente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String nome;

    @Size(max = 200)
    private String ramoAtuacao;

    @OneToMany(mappedBy = "concorrente")
    private List<Website> websites;

    public Concorrente(ConcorrenteDTO concorrenteDTO) {
    }
}

