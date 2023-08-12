package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.request.EditalRequest;
import br.com.projeto.mercado.api.request.ProdutoRequest;
import br.com.projeto.mercado.api.response.EditalResponse;
import br.com.projeto.mercado.models.Edital;
import br.com.projeto.mercado.models.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EditalMapper {

    EditalResponse toResponse(Edital entity);

    Edital resquestToEntity(EditalRequest model);

    void update(@MappingTarget Edital edital, EditalRequest editalRequest);
}
