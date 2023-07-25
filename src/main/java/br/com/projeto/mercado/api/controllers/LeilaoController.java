package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.filter.LeilaoFiltro;
import br.com.projeto.mercado.api.response.LeilaoResponse;
import br.com.projeto.mercado.service.LeilaoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/leiloes")
public class LeilaoController {

    private final LeilaoService leilaoService;

    @GetMapping
    public ResponseEntity<Page<LeilaoResponse>> pesquisar(LeilaoFiltro filter,
                                                          @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(leilaoService.search(filter, pageable));
    }

}
