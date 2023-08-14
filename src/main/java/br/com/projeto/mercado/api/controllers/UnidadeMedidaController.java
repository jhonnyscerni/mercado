package br.com.projeto.mercado.api.controllers;


import br.com.projeto.mercado.api.response.GrupoResponse;
import br.com.projeto.mercado.api.response.UnidadeMedidaResponse;
import br.com.projeto.mercado.service.UnidadeMedidaService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/unidade-medidas")
public class UnidadeMedidaController {

    private final UnidadeMedidaService unidadeMedidaService;

    @GetMapping
    public ResponseEntity<List<UnidadeMedidaResponse>> list() {
        return ResponseEntity.ok().body(unidadeMedidaService.findAll());
    }
}
