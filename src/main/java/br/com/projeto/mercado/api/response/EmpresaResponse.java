package br.com.projeto.mercado.api.response;

import lombok.Data;

@Data
public class EmpresaResponse {

    private Long id;

    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private String inscEstadual;

    private String inscMunicipal;

    private String categoria;

    private String telefone;

    private EnderecoResponse endereco = new EnderecoResponse();

}
