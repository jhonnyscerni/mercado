package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.filter.EditalFiltro;
import br.com.projeto.mercado.api.request.EditalRequest;
import br.com.projeto.mercado.api.response.EditalResponse;
import br.com.projeto.mercado.models.Edital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EditalService {

    Page<EditalResponse> search(EditalFiltro filter, Pageable pageable);

    Edital buscarOuFalhar(Long id);

    EditalResponse findByIdEditalResponse(Long id);

    EditalResponse save(EditalRequest editalRequest);

    EditalResponse update(Long id, EditalRequest editalRequest);
}
