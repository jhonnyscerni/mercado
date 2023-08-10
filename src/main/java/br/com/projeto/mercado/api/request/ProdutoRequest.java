package br.com.projeto.mercado.api.request;

import lombok.Data;

@Data
public class ProdutoRequest {

    private String codigoExterno;

    private String nome;

    private String descricao;

    private Long categoriaId;

    private Long marcaId;
}
