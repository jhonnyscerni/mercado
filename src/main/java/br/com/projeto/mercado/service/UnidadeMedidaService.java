package br.com.projeto.mercado.service;


import br.com.projeto.mercado.api.response.UnidadeMedidaResponse;
import br.com.projeto.mercado.models.UnidadeMedida;

import java.util.List;

public interface UnidadeMedidaService {
    List<UnidadeMedidaResponse> findAll();

    UnidadeMedida buscarOuFalhar(Long id);

}
