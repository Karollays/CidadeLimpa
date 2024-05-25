package br.com.fiap.cidadelimpa.repository;

import br.com.fiap.cidadelimpa.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {}
