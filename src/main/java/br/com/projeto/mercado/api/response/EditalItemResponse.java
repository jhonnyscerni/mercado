package br.com.projeto.mercado.api.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EditalItemResponse {

    private Long id;

    private String especificacao;

    private String observacao;

    private ProdutoResponse produto;

    private UnidadeMedidaResponse unidadeMedida;

    private Double quantidade;

    private Boolean propostaParcial = Boolean.FALSE;

    private Double peso;

    private Double largura;

    private Double altura;

    private Double profundidade;

    private BigDecimal valorMaximo = BigDecimal.ZERO;
}
