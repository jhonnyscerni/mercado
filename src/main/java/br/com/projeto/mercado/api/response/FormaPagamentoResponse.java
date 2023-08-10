package br.com.projeto.mercado.api.response;

import lombok.Data;

@Data
public class FormaPagamentoResponse {

    private Long id;

    private String nome;

    private String descricao;
}
