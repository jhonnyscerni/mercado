package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.service.EditalItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: Remover essa classe e fazer o delete no EditalItemController validando o edital remover do front tbm

@AllArgsConstructor
@RestController
@RequestMapping("/item-edital")
public class ItemEditalController {

    private final EditalItemService editalItemService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        editalItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
