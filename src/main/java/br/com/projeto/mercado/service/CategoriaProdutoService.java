package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.request.CategoriaProdutoRequest;
import br.com.projeto.mercado.api.response.CategoriaProdutoResponse;
import br.com.projeto.mercado.models.CategoriaProduto;

import java.util.List;

public interface CategoriaProdutoService {
    CategoriaProduto buscarOuFalhar(Long id);

    List<CategoriaProdutoResponse> findAll();

    CategoriaProdutoResponse findByIdCategoriaProdutoResponse(Long id);

    void delete(Long id);

    CategoriaProdutoResponse save(CategoriaProdutoRequest categoriaProdutoRequest);

    CategoriaProdutoResponse update(Long id, CategoriaProdutoRequest categoriaProdutoRequest);

    void existsByCategoriaNomeDesc(CategoriaProduto categoriaProduto, String nomeDesc);
}
