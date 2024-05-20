package br.com.fiap.challengePlusoft.repository;

import br.com.fiap.challengePlusoft.model.Colaborador;
import br.com.fiap.challengePlusoft.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findAll();

    Empresa save(Empresa empresa);

    void delete(Empresa empresa);

    Optional<Empresa> findById(Long id);
}

