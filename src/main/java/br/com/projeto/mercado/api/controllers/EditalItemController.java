package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.response.EditalItemResponse;
import br.com.projeto.mercado.service.EditalItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/editais/{editalId}/item")
public class EditalItemController {

    private final EditalItemService editalItemService;

    @GetMapping
    public ResponseEntity<List<EditalItemResponse>> search(@PathVariable Long editalId) {
        List<EditalItemResponse> editalItemResponses = editalItemService.search(editalId);
        return ResponseEntity.ok(editalItemResponses);
    }
}
