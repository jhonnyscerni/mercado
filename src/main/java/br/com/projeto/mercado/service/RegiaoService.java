package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.response.RegiaoResponse;

import java.util.List;

public interface RegiaoService {

    List<RegiaoResponse> search(Long editalId);

    List<RegiaoResponse> findAll();
}
