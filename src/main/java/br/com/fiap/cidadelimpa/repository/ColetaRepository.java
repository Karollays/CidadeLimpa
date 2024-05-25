package br.com.fiap.cidadelimpa.repository;

import br.com.fiap.cidadelimpa.model.Coleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta, Long> {}
