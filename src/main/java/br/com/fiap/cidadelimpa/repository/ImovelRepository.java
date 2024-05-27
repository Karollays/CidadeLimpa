package br.com.fiap.cidadelimpa.repository;

import br.com.fiap.cidadelimpa.model.Imovel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    @Query("SELECT t FROM Imovel t WHERE t.bairro = :bairro")
    Page<Imovel> buscarBairro(@Param("bairro") String bairro, Pageable paginacao);
}