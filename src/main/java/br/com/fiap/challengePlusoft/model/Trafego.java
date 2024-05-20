package br.com.fiap.challengePlusoft.model;

import br.com.fiap.challengePlusoft.dto.TrafegoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Trafego {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer numVisitantes;

    @NotNull
    private LocalDateTime tempoMedioVisitaSite;

    @ManyToOne
    @JoinColumn(name = "id_website")
    private Website website;

    public Trafego(TrafegoDTO trafegoDTO) {
    }

    public void setIdWebsite(Object idWebsite) {

    }
}

