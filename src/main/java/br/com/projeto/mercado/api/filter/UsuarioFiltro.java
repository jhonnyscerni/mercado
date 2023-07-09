package br.com.projeto.mercado.api.filter;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioFiltro {

    private Long empresaId;

    private String username;

    private String email;
}
