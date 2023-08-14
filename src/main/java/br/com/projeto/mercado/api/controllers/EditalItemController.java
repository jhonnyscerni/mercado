package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.request.ItemEditalRequest;
import br.com.projeto.mercado.api.response.EditalItemResponse;
import br.com.projeto.mercado.service.EditalItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<EditalItemResponse> registrar(@PathVariable Long editalId, @RequestBody @Valid ItemEditalRequest editalRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(editalItemService.saveItemEdital(editalId, editalRequest));
    }
}
