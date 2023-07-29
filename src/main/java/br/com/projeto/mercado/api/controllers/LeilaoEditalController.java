package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.filter.LeilaoFiltro;
import br.com.projeto.mercado.api.request.LeilaoRequest;
import br.com.projeto.mercado.api.response.LeilaoResponse;
import br.com.projeto.mercado.service.LeilaoService;
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
@RequestMapping("/editais/{id}/leilao")
public class LeilaoEditalController {

    private final LeilaoService leilaoService;

    @GetMapping
    public ResponseEntity<Page<LeilaoResponse>> pesquisar(@PathVariable Long id,
                                                          @PageableDefault(size = 10) Pageable pageable) {
        LeilaoFiltro filter = new LeilaoFiltro();
        filter.setEditalId(id);
        return ResponseEntity.ok().body(leilaoService.search(filter, pageable));
    }

    @PostMapping
    public ResponseEntity<LeilaoResponse> registrar(@PathVariable Long id, @RequestBody @Valid LeilaoRequest leilaoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(leilaoService.save(id, leilaoRequest));
    }
}
