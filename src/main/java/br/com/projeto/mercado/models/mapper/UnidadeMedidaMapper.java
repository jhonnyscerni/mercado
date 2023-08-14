package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.response.UnidadeMedidaResponse;
import br.com.projeto.mercado.models.UnidadeMedida;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnidadeMedidaMapper {

    UnidadeMedidaResponse toResponse(UnidadeMedida entity);
}
