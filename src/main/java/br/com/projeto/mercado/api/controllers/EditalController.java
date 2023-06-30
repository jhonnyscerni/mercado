package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.filter.EditalFiltro;
import br.com.projeto.mercado.api.response.EditalResponse;
import br.com.projeto.mercado.service.EditalService;
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
@RequestMapping("/editais")
public class EditalController {

    private final EditalService editalService;

    @GetMapping
    public ResponseEntity<Page<EditalResponse>> pesquisar(EditalFiltro filter,
                                                          @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(editalService.search(filter, pageable));
    }
}
