package br.com.fiap.challengePlusoft.repository;

import br.com.fiap.challengePlusoft.model.Trafego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrafegoRepository extends JpaRepository<Trafego, Long> {
    List<Trafego> findAll();

    Trafego save(Trafego trafego);

    void delete(Trafego trafego);

    Optional<Trafego> findById(Long id);
}

