package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.request.MarcaProdutoRequest;
import br.com.projeto.mercado.api.response.MarcaProdutoResponse;
import br.com.projeto.mercado.models.MarcaProduto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MarcaProdutoMapper {

    MarcaProdutoResponse toResponse(MarcaProduto entity);

    MarcaProduto resquestToEntity(MarcaProdutoRequest marcaProdutoRequest);

    void update(@MappingTarget MarcaProduto marcaProduto, MarcaProdutoRequest marcaProdutoRequest);
}
