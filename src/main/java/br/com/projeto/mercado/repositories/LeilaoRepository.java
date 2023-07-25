package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LeilaoRepository extends JpaRepository<Leilao, Long>, JpaSpecificationExecutor<Leilao> {
}
