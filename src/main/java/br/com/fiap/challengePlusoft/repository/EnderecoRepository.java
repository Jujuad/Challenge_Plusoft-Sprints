package br.com.fiap.challengePlusoft.repository;


import br.com.fiap.challengePlusoft.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findAll();

    Endereco save(Endereco endereco);

    void delete(Endereco endereco);

    Optional<Endereco> findById(Long id);
}

