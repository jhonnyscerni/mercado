package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.request.EditalArquivoRequest;
import br.com.projeto.mercado.api.response.EditalArquivoResponse;
import br.com.projeto.mercado.models.EditalArquivo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EditalArquivoMapper {

    EditalArquivoResponse toResponse(EditalArquivo entity);

    EditalArquivo resquestToEntity(EditalArquivoRequest model);
}
