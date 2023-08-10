package br.com.projeto.mercado.api.controllers;


import br.com.projeto.mercado.api.filter.ProdutoFiltro;
import br.com.projeto.mercado.api.request.ProdutoRequest;
import br.com.projeto.mercado.api.response.ProdutoResponse;
import br.com.projeto.mercado.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Page<ProdutoResponse>> pesquisar(ProdutoFiltro filter,
                                                           @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(produtoService.search(filter, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.findByIdProdutoResponse(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> registrar(@RequestBody @Valid ProdutoRequest produtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long id,
                                                     @RequestBody @Valid ProdutoRequest produtoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.update(id, produtoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
