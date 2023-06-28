package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.filter.UsuarioFiltro;
import br.com.projeto.mercado.api.request.UsuarioRequest;
import br.com.projeto.mercado.api.response.UsuarioResponse;
import br.com.projeto.mercado.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<UsuarioResponse>> pesquisar(UsuarioFiltro filter,
                                                           @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(usuarioService.search(filter, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.findByIdUserResponse(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> atualizar(@PathVariable Long id,
                                                     @RequestBody @Valid UsuarioRequest usuarioRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(id, usuarioRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
