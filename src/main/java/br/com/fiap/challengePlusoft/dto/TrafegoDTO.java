package br.com.fiap.challengePlusoft.dto;

import br.com.fiap.challengePlusoft.model.Trafego;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class TrafegoDTO {
    @NotNull
    private Integer numVisitantes;

    @NotNull
    private LocalDateTime tempoMedioVisitaSite;

    @NotNull
    private Long idWebsite;

    public TrafegoDTO(Trafego trafego) {
    }

    public Integer getNumVisitantes() {
        return 0;
    }

    public LocalDateTime getTempoMedioVisitaSite() {
        return null;
    }

    public Object getIdWebsite() {
        return null;
    }
}

