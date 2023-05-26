package br.com.projeto.mercado.models.mapper;

import br.com.projeto.mercado.dto.UserDto;
import br.com.projeto.mercado.models.User;
import br.com.projeto.mercado.utils.ModelMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends ModelMapper<User, UserDto> {
}
