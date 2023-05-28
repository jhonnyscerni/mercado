package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.filter.UsuarioFiltro;
import br.com.projeto.mercado.api.request.UserRequest;
import br.com.projeto.mercado.api.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    UserDto saveUser(UserDto userDto);

    UserResponse save(UserRequest userRequest);

    UserDto resetPassword(String email);

    Page<UserDto> search(UsuarioFiltro filter, Pageable pageable);

    void delete(Long id);


}
