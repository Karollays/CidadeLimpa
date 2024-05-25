package br.com.fiap.cidadelimpa.repository;

import br.com.fiap.cidadelimpa.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {}
