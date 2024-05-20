package br.com.fiap.challengePlusoft.repository;

import br.com.fiap.challengePlusoft.model.Colaborador;
import br.com.fiap.challengePlusoft.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long> {
    List<Website> findAll();

    Website save(Website website);

    void delete(Website website);

    Optional<Website> findById(Long id);
}

