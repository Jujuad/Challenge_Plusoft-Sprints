package br.com.fiap.challengePlusoft.model;

import br.com.fiap.challengePlusoft.dto.ColaboradorDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Colaborador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    public Colaborador(ColaboradorDTO colaboradorDTO) {
    }

    public void setIdUsuario(Long idUsuario) {
    }

    public void setIdEmpresa(Long idEmpresa) {

    }
}

