package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.request.UsuarioRequest;
import br.com.projeto.mercado.api.response.UsuarioResponse;
import br.com.projeto.mercado.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UserDto toModel(Usuario entity);

    Usuario toEntity(UserDto model);

    UsuarioResponse toResponse(Usuario entity);

    Usuario resquestToEntity(UsuarioRequest model);

    void update(@MappingTarget Usuario user, UsuarioRequest usuarioRequest);
}
