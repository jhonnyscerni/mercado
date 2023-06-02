package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.request.CategoriaProdutoRequest;
import br.com.projeto.mercado.api.response.CategoriaProdutoResponse;
import br.com.projeto.mercado.models.CategoriaProduto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoriaProdutoMapper {

    CategoriaProdutoResponse toResponse(CategoriaProduto entity);

    CategoriaProduto resquestToEntity(CategoriaProdutoRequest categoriaProdutoRequest);

    void update(@MappingTarget CategoriaProduto categoriaProduto, CategoriaProdutoRequest categoriaProdutoRequest);
}
