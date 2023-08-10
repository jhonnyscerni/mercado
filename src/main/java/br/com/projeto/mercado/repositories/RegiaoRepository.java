package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

    @Query("from Regiao where edital.id = :edital")
    List<Regiao> findByEditalId(@Param("edital") Long editalId);
}
