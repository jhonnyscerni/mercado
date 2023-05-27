package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.filter.UsuarioFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    UserDto saveUser(UserDto userDto);

    UserDto resetPassword(String email);

    Page<UserDto> search(UsuarioFiltro filter, Pageable pageable);
}
