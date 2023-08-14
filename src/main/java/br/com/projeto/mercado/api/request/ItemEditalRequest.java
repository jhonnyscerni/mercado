package br.com.projeto.mercado.api.request;

import br.com.projeto.mercado.models.Edital;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemEditalRequest {

    private Long id;

    private String especificacao;

    private String observacao;

    private Long produtoId;

    private Long unidadeMedidaId;

    private Edital edital;

    private Double quantidade;

    private Boolean propostaParcial = Boolean.FALSE;

    private Double peso;

    private Double largura;

    private Double altura;

    private Double profundidade;

    private BigDecimal valorMaximo = BigDecimal.ZERO;
}
