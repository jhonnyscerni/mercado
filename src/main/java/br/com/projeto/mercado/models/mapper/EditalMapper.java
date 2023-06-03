package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.response.EditalResponse;
import br.com.projeto.mercado.models.Edital;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EditalMapper {

    EditalResponse toResponse(Edital entity);
}
