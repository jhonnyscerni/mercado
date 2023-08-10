package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.filter.ProdutoFiltro;
import br.com.projeto.mercado.api.request.ProdutoRequest;
import br.com.projeto.mercado.api.request.UsuarioRequest;
import br.com.projeto.mercado.api.response.ProdutoResponse;
import br.com.projeto.mercado.api.response.UsuarioResponse;
import br.com.projeto.mercado.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {

    Page<ProdutoResponse> search(ProdutoFiltro filter, Pageable pageable);

    void delete(Long id);

    Produto buscarOuFalhar(Long id);

    ProdutoResponse findByIdProdutoResponse(Long id);

    ProdutoResponse save(ProdutoRequest produtoRequest);

    ProdutoResponse update(Long id, ProdutoRequest produtoRequest);
}
