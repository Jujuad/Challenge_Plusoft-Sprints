package br.com.fiap.challengePlusoft.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrafegoDTO {
    @NotNull
    private Integer numVisitantes;

    @NotNull
    private LocalDateTime tempoMedioVisitaSite;

    @NotNull
    private Long idWebsite;

    public TrafegoDTO() {
    }

    public TrafegoDTO(Integer numVisitantes, LocalDateTime tempoMedioVisitaSite, Long idWebsite) {
        this.numVisitantes = numVisitantes;
        this.tempoMedioVisitaSite = tempoMedioVisitaSite;
        this.idWebsite = idWebsite;
    }
}
