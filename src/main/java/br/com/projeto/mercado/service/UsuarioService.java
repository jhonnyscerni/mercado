package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.filter.UsuarioFiltro;
import br.com.projeto.mercado.api.request.UsuarioRequest;
import br.com.projeto.mercado.api.response.UsuarioResponse;
import br.com.projeto.mercado.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void passwordNotEquals(Usuario user, UsuarioRequest usuarioRequest);

    UsuarioResponse saveUser(UserDto userDto);

    UsuarioResponse save(UsuarioRequest usuarioRequest);

    UsuarioResponse update(Long id, UsuarioRequest usuarioRequest);

    Usuario buscarOuFalhar(Long usuarioId);

    UsuarioResponse resetPassword(String email);

    Page<UsuarioResponse> search(UsuarioFiltro filter, Pageable pageable);

    void delete(Long id);

    UsuarioResponse findByIdUserResponse(Long id);

    void existsByUserName(Usuario usuario, String username);
}
