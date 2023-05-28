package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.request.UserRequest;
import br.com.projeto.mercado.api.response.UserResponse;
import br.com.projeto.mercado.models.Usuario;
import br.com.projeto.mercado.utils.ModelMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UserDto toModel(Usuario entity);

    Usuario toEntity(UserDto model);

    UserResponse toResponse(Usuario entity);

    Usuario resquestToEntity(UserRequest model);

    void update(@MappingTarget Usuario user, UserRequest userRequest);
}
