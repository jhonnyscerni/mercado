package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.response.RegiaoResponse;
import br.com.projeto.mercado.models.Regiao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegiaoMapper {

    RegiaoResponse toResponse(Regiao entity);
}
