package br.com.projeto.mercado.service;

import br.com.projeto.mercado.dto.UserDto;

public interface UserService {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    UserDto saveUser(UserDto userDto);

    UserDto resetPassword(String email);
}
