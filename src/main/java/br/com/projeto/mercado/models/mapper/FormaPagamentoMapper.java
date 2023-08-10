package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.response.FormaPagamentoResponse;
import br.com.projeto.mercado.models.FormaPagamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormaPagamentoMapper {

    FormaPagamentoResponse toResponse(FormaPagamento entity);
}
