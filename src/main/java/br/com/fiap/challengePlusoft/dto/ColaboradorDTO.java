package br.com.fiap.challengePlusoft.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColaboradorDTO {
    private Long id;

    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idEmpresa;
}
