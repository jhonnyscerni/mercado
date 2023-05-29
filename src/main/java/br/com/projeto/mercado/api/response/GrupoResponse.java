package br.com.projeto.mercado.api.response;

import br.com.projeto.mercado.models.enums.TipoGrupo;
import lombok.Data;

@Data
public class GrupoResponse {

    private Long id;

    private TipoGrupo nome;

}
