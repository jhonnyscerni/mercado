package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.Edital;
import br.com.projeto.mercado.models.EditalArquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EditalRepository extends JpaRepository<Edital, Long>, JpaSpecificationExecutor<Edital> {

    @Query("select f from EditalArquivo f join f.edital p "
            + "where f.edital.id = :editalId")
    Optional<Edital> findArquivoById(Long editalId);
}
