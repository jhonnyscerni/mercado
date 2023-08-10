package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.EditalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EditalItemRepository extends JpaRepository<EditalItem, Long> {

    @Query("from EditalItem where edital.id = :edital")
    List<EditalItem> findByEditalId(@Param("edital") Long editalId);
}
