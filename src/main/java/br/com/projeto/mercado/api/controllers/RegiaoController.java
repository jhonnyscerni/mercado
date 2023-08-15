package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.response.RegiaoResponse;
import br.com.projeto.mercado.service.RegiaoService;
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
@RequestMapping("/regioes")
public class RegiaoController {

    private final RegiaoService regiaoService;

    @GetMapping
    public ResponseEntity<List<RegiaoResponse>> list() {
        return ResponseEntity.ok().body(regiaoService.findAll());
    }
}
