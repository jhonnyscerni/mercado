package br.com.projeto.mercado.api.response;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class EditalResponse {

    private Long id;

    private Long numero;

    private OffsetDateTime dataInicio;

    private OffsetDateTime dataFim;

    private EmpresaResponse empresa;

    private ProdutoResponse produto;

    private EnderecoResponse endereco;

}
