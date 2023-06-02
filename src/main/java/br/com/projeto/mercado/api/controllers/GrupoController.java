package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.response.GrupoResponse;
import br.com.projeto.mercado.service.GrupoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    @GetMapping
    public ResponseEntity<List<GrupoResponse>> list() {
        return ResponseEntity.ok().body(grupoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(grupoService.findByIdGrupoResponse(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        grupoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
