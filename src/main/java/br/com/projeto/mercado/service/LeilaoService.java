package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.filter.LeilaoFiltro;
import br.com.projeto.mercado.api.request.LeilaoRequest;
import br.com.projeto.mercado.api.response.LeilaoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LeilaoService {

    Page<LeilaoResponse> search(LeilaoFiltro filter, Pageable pageable);

    LeilaoResponse save(Long id, LeilaoRequest leilaoRequest);
}

