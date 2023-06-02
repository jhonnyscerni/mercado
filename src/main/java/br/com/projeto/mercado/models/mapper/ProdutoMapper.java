package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.response.ProdutoResponse;
import br.com.projeto.mercado.models.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoResponse toResponse(Produto entity);
}
