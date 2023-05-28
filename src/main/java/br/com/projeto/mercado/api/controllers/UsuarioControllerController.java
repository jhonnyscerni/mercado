package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.filter.UsuarioFiltro;
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

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerController {

    private final UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<Page<UserDto>> pesquisar(UsuarioFiltro filter,
                                                   @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(usuarioService.search(filter, pageable));
    }

    @PostMapping
    public ResponseEntity<UserDto> registrarUsuario(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUser(userDto));
    }
}
