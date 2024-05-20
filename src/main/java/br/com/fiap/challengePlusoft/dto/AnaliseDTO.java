package br.com.fiap.challengePlusoft.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Data
public class AnaliseDTO {

    private Long id;

    @NotNull
    @Size(max = 200)
    private String resultadosAnalise;

    @NotNull
    private Date dataAnalise;

    @NotNull
    private Long idTrafego;

    public AnaliseDTO() {
    }

    public AnaliseDTO(@NotNull String resultadosAnalise, @NotNull Date dataAnalise, @NotNull Long idTrafego) {
        this.resultadosAnalise = resultadosAnalise;
        this.dataAnalise = dataAnalise;
        this.idTrafego = idTrafego;
    }
}

