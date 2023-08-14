package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.request.ItemEditalRequest;
import br.com.projeto.mercado.api.response.EditalItemResponse;

import java.util.List;

public interface EditalItemService {

    List<EditalItemResponse> search(Long editalId);

    void delete(Long id);

    EditalItemResponse saveItemEdital(Long editalId, ItemEditalRequest editalRequest);
}
