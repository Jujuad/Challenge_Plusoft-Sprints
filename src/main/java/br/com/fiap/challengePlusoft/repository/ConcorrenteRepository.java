package br.com.fiap.challengePlusoft.repository;

import br.com.fiap.challengePlusoft.model.Colaborador;
import br.com.fiap.challengePlusoft.model.Concorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConcorrenteRepository extends JpaRepository<Concorrente, Long> {
    List<Concorrente> findAll();

    Concorrente save(Concorrente concorrente);

    void delete(Concorrente concorrente);

    Optional<Concorrente> findById(Long id);
}

