package br.com.fiap.challengePlusoft.model;

import br.com.fiap.challengePlusoft.dto.AnaliseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Analise {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 200)
    private String resultadosAnalise;

    @NotNull
    private LocalDate dataAnalise;

    @ManyToOne
    @JoinColumn(name = "id_trafego")
    private Trafego trafego;

    public Analise(AnaliseDTO analiseDTO) {
    }

    public void setIdTrafego(Long idTrafego) {
    }

    public void setDataAnalise(Date dataAnalise) {

    }
}

