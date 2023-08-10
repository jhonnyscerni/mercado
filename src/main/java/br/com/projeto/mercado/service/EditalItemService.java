package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.response.EditalItemResponse;

import java.util.List;

public interface EditalItemService {

    List<EditalItemResponse> search(Long editalId);
}
