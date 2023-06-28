package br.com.projeto.mercado.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoriaProdutoRequest {

    private Long id;

    private String nomeDesc;

    //@NotNull
    private Long empresaId;
}
