package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.request.MarcaProdutoRequest;
import br.com.projeto.mercado.api.response.MarcaProdutoResponse;
import br.com.projeto.mercado.service.MarcaProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/marcaprodutos")
public class MarcaProdutoController {

    private final MarcaProdutoService marcaProdutoService;

    @GetMapping
    public ResponseEntity<List<MarcaProdutoResponse>> listar() {
        return ResponseEntity.ok().body(marcaProdutoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaProdutoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(marcaProdutoService.findByIdMarcaProdutoResponse(id));
    }

    @PostMapping
    public ResponseEntity<MarcaProdutoResponse> registrar(@RequestBody @Valid MarcaProdutoRequest marcaProdutoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaProdutoService.save(marcaProdutoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaProdutoResponse> atualizar(@PathVariable Long id,
                                                          @RequestBody @Valid MarcaProdutoRequest marcaProdutoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(marcaProdutoService.update(id, marcaProdutoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        marcaProdutoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
