package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.filter.EditalFiltro;
import br.com.projeto.mercado.api.response.EditalResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EditalService {

    Page<EditalResponse> search(EditalFiltro filter, Pageable pageable);
}
