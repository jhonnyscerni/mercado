package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.models.Usuario;
import br.com.projeto.mercado.utils.ModelMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends ModelMapper<Usuario, UserDto> {
}
