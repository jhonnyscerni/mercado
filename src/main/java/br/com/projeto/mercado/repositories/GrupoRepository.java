package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.Grupo;
import br.com.projeto.mercado.models.enums.TipoGrupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    Optional<Grupo> findByNome(TipoGrupo name);
}
