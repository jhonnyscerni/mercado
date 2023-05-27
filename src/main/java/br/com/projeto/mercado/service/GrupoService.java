package br.com.projeto.mercado.service;


import br.com.projeto.mercado.models.Grupo;
import br.com.projeto.mercado.models.enums.TipoGrupo;

public interface GrupoService {

    Grupo findByRoleName(TipoGrupo tipoGrupo);
}
