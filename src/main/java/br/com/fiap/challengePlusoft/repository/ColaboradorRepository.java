package br.com.fiap.challengePlusoft.repository;

import br.com.fiap.challengePlusoft.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    List<Colaborador> findAll();

    Colaborador save(Colaborador colaborador);

    void delete(Colaborador colaborador);

    Optional<Colaborador> findById(Long id);
}

