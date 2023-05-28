package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.filter.UsuarioFiltro;
import br.com.projeto.mercado.api.request.UserRequest;
import br.com.projeto.mercado.api.response.UserResponse;
import br.com.projeto.mercado.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UsuarioService {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void passwordNotEquals(Usuario user, UserRequest userRequest);

    UserDto saveUser(UserDto userDto);

    UserResponse save(UserRequest userRequest);

    UserResponse update(Long id, UserRequest userRequest);

    Usuario buscarOuFalhar(Long usuarioId);

    UserDto resetPassword(String email);

    Page<UserResponse> search(UsuarioFiltro filter, Pageable pageable);

    void delete(Long id);
}
