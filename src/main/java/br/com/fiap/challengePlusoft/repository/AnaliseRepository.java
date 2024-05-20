package br.com.fiap.challengePlusoft.repository;

import br.com.fiap.challengePlusoft.model.Analise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Long> {
    Analise save(Analise analise);

    void delete(Analise analise);

    List<Analise> findAll();
}

