package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LeilaoRepository extends JpaRepository<Leilao, Long>, JpaSpecificationExecutor<Leilao> {

    @Query("FROM Leilao l " +
            "WHERE l.edital.id = :edital " +
            "AND l.usuario.empresa.id =:empresa ")
    Optional<Leilao> findIdUsuarioAndIdLeilao(
            @Param("edital") Long id,
            @Param("empresa") Long empresaId);
}
