package br.com.projeto.mercado.api.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditalFiltro {

    private Long empresaId;
    private Long numero;

    private boolean meusDados = false;
}
