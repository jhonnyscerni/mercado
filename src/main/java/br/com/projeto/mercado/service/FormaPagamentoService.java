package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.response.FormaPagamentoResponse;

import java.util.List;

public interface FormaPagamentoService {

    List<FormaPagamentoResponse> search(Long editalId);

    List<FormaPagamentoResponse> findAll();
}
