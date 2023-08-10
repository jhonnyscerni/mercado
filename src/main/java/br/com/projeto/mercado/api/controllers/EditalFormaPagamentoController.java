package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.response.FormaPagamentoResponse;
import br.com.projeto.mercado.service.FormaPagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/editais/{editalId}/formas-pagamento")
public class EditalFormaPagamentoController {

    private final FormaPagamentoService formaPagamentoService;

    @GetMapping
    public ResponseEntity<List<FormaPagamentoResponse>> search(@PathVariable Long editalId) {
        List<FormaPagamentoResponse> responseList = formaPagamentoService.search(editalId);
        return ResponseEntity.ok(responseList);
    }
}
