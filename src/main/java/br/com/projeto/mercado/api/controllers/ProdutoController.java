package br.com.projeto.mercado.api.controllers;


import br.com.projeto.mercado.api.filter.ProdutoFiltro;
import br.com.projeto.mercado.api.response.ProdutoResponse;
import br.com.projeto.mercado.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
