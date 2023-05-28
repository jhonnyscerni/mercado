package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.filter.UsuarioFiltro;
import br.com.projeto.mercado.api.request.UserRequest;
import br.com.projeto.mercado.api.response.UserResponse;
import br.com.projeto.mercado.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerController {

    private final UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<Page<UserResponse>> pesquisar(UsuarioFiltro filter,
                                                   @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(usuarioService.search(filter, pageable));
    }

    @PostMapping
    public ResponseEntity<UserResponse> registrar(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> atualizar(@PathVariable Long id,
                                               @RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
