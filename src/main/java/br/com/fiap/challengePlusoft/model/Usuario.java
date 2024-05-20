package br.com.fiap.challengePlusoft.model;

import br.com.fiap.challengePlusoft.dto.UsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 6, max = 200)
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Colaborador> colaboradores;

    public Usuario(UsuarioDTO usuarioDTO) {
    }
}

