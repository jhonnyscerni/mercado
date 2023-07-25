package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.request.LeilaoRequest;
import br.com.projeto.mercado.api.response.LeilaoResponse;
import br.com.projeto.mercado.models.Leilao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeilaoMapper {

    LeilaoResponse toResponse(Leilao entity);

    Leilao resquestToEntity(LeilaoRequest model);
}
