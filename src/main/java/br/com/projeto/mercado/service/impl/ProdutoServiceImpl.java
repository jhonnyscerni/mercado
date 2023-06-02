package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.filter.ProdutoFiltro;
import br.com.projeto.mercado.api.response.ProdutoResponse;
import br.com.projeto.mercado.models.mapper.ProdutoMapper;
import br.com.projeto.mercado.repositories.ProdutoRepository;
import br.com.projeto.mercado.repositories.specs.ProdutoSpecification;
import br.com.projeto.mercado.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    @Override
    public Page<ProdutoResponse> search(ProdutoFiltro filter, Pageable pageable) {
        log.debug("GET ProdutoFiltro filter received {} ", filter.toString());
        return produtoRepository.findAll(new ProdutoSpecification(filter), pageable).map(produtoMapper::toResponse);

    }
}
