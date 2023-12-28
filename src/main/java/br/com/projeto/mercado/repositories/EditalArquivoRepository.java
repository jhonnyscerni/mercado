package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.EditalArquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EditalArquivoRepository extends JpaRepository<EditalArquivo, Long> {

    @Query("select f from EditalArquivo f join f.edital p "
            + "where f.edital.id = :editalId")
    Optional<EditalArquivo> findEditalArquivoById(Long editalId);
}
