package br.com.fiap.cidadelimpa.repository;

import br.com.fiap.cidadelimpa.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {}
