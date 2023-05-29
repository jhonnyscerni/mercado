package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.response.GrupoResponse;
import br.com.projeto.mercado.models.Grupo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrupoMapper {

    GrupoResponse toResponse(Grupo entity);
}
