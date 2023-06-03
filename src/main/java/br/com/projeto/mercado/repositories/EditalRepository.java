package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.Edital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EditalRepository extends JpaRepository<Edital, Long>, JpaSpecificationExecutor<Edital> {
}
