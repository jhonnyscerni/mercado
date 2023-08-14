package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.UnidadeMedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeMeditaRepository extends JpaRepository<UnidadeMedida, Long> {
}
