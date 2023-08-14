package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.request.ItemEditalRequest;
import br.com.projeto.mercado.api.request.LeilaoRequest;
import br.com.projeto.mercado.api.response.EditalItemResponse;
import br.com.projeto.mercado.models.EditalItem;
import br.com.projeto.mercado.models.Leilao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EditalItemMapper {

    EditalItemResponse toResponse(EditalItem entity);

    EditalItem resquestToEntity(ItemEditalRequest model);
}
