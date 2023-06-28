package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.request.MarcaProdutoRequest;
import br.com.projeto.mercado.api.response.MarcaProdutoResponse;
import br.com.projeto.mercado.models.MarcaProduto;

import java.util.List;

public interface MarcaProdutoService {

    MarcaProduto buscarOuFalhar(Long id);

    List<MarcaProdutoResponse> findAll();

    MarcaProdutoResponse findByIdMarcaProdutoResponse(Long id);

    void delete(Long id);

    MarcaProdutoResponse save(MarcaProdutoRequest marcaProdutoRequest);

    MarcaProdutoResponse update(Long id, MarcaProdutoRequest marcaProdutoRequest);
}
