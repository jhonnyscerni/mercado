package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.response.RegiaoResponse;
import br.com.projeto.mercado.service.RegiaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/editais/{editalId}/regioes")
public class EditalRegiaoController {

    private final RegiaoService regiaoService;

    @GetMapping
    public ResponseEntity<List<RegiaoResponse>> search(@PathVariable Long editalId) {
        List<RegiaoResponse> responseList = regiaoService.search(editalId);
        return ResponseEntity.ok(responseList);
    }
}
