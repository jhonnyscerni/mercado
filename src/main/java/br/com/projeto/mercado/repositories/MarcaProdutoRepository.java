package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.MarcaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaProdutoRepository extends JpaRepository<MarcaProduto, Long> {

    Optional<MarcaProduto> findByNomeDesc(String name);
}
