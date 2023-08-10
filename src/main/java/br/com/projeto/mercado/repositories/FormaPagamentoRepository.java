package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

    @Query("from FormaPagamento where edital.id = :edital")
    List<FormaPagamento> findByEditalId(@Param("edital") Long editalId);
}
