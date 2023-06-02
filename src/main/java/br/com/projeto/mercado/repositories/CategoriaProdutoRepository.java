package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

    Optional<CategoriaProduto> findByNomeDesc(String name);

    @Query(nativeQuery = true, value = "select count(1) > 0 from categoria_produto where upper(trim(nome_desc)) = upper(trim(?1))")
    public boolean existeCategoria(String nomeCategoria);

}
