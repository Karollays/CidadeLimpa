package br.com.fiap.cidadelimpa.repository;

import br.com.fiap.cidadelimpa.model.Coleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta, Long> {
    @Query("SELECT t FROM Coleta t WHERE t.dataColeta BETWEEN :dataInicial AND :dataFinal")
    List<Coleta> listarPeriodo(
            @Param("dataInicial") LocalDate dataInicio,
            @Param("dataFinal") LocalDate dataFinal
    );
}
