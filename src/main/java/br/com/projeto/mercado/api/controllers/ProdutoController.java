package br.com.projeto.mercado.api.controllers;


import br.com.projeto.mercado.api.filter.ProdutoFiltro;
import br.com.projeto.mercado.api.response.ProdutoResponse;
import br.com.projeto.mercado.security.AuthenticationCurrentUserService;
import br.com.projeto.mercado.security.UserDetailsImpl;
import br.com.projeto.mercado.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
