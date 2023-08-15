package br.com.projeto.mercado.api.controllers;


import br.com.projeto.mercado.api.response.FormaPagamentoResponse;
import br.com.projeto.mercado.service.FormaPagamentoService;
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
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

    private final FormaPagamentoService formaPagamentoService;

    @GetMapping
    public ResponseEntity<List<FormaPagamentoResponse>> list() {
        return ResponseEntity.ok().body(formaPagamentoService.findAll());
    }
}
