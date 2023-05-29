package br.com.projeto.mercado.service;


import br.com.projeto.mercado.api.response.GrupoResponse;
import br.com.projeto.mercado.models.Grupo;
import br.com.projeto.mercado.models.enums.TipoGrupo;

import java.util.List;

public interface GrupoService {

    Grupo findByRoleName(TipoGrupo tipoGrupo);

    Grupo buscarOuFalhar(Long id);

    List<GrupoResponse> findAll();

    GrupoResponse findByIdGrupoResponse(Long id);
}
