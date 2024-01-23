package br.com.projeto.mercado.api.response;

import lombok.Data;


@Data
public class AreaInteresseResponse {

    private Long id;

    private String nome;

    private String descricao;

    private EmpresaResponse empresa;
}
