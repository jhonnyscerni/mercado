package br.com.projeto.mercado.api.request;

import lombok.Data;

@Data
public class MarcaProdutoRequest {

    private Long id;

    private String nomeDesc;

    private Long empresaId;
}
