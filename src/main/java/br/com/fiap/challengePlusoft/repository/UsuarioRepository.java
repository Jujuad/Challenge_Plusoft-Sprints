package br.com.fiap.challengePlusoft.repository;

import br.com.fiap.challengePlusoft.model.Colaborador;
import br.com.fiap.challengePlusoft.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    void delete(Usuario usuario);

    Optional<Usuario> findById(Long id);
}

