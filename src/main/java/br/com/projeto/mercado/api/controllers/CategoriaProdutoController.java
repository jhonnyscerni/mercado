package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.request.CategoriaProdutoRequest;
import br.com.projeto.mercado.api.response.CategoriaProdutoResponse;
import br.com.projeto.mercado.service.CategoriaProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categoriaprodutos")
public class CategoriaProdutoController {

    private final CategoriaProdutoService categoriaProdutoService;

    @GetMapping
    public ResponseEntity<List<CategoriaProdutoResponse>> listar() {
        return ResponseEntity.ok().body(categoriaProdutoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProdutoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoriaProdutoService.findByIdCategoriaProdutoResponse(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaProdutoResponse> registrar(@RequestBody @Valid CategoriaProdutoRequest categoriaProdutoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaProdutoService.save(categoriaProdutoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProdutoResponse> atualizar(@PathVariable Long id,
                                                              @RequestBody @Valid CategoriaProdutoRequest categoriaProdutoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaProdutoService.update(id, categoriaProdutoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        categoriaProdutoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
