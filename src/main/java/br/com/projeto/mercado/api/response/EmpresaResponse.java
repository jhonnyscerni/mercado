package br.com.projeto.mercado.api.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    private String emailResponsavel;

    private String telefoneResponsavel;

    private String nomeResponsavel;

    private String homepage;

    private EnderecoResponse endereco = new EnderecoResponse();

    private List<AreaInteresseResponse> areaInteresses = new ArrayList<>();

}
