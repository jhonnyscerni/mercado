package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.request.ProdutoRequest;
import br.com.projeto.mercado.api.request.UsuarioRequest;
import br.com.projeto.mercado.api.response.ProdutoResponse;
import br.com.projeto.mercado.models.Produto;
import br.com.projeto.mercado.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoResponse toResponse(Produto entity);

    Produto resquestToEntity(ProdutoRequest model);

    void update(@MappingTarget Produto produto, ProdutoRequest produtoRequest);
}
