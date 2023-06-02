package br.com.projeto.mercado.api.response;

import br.com.projeto.mercado.models.CategoriaProduto;
import br.com.projeto.mercado.models.ImagemProduto;
import br.com.projeto.mercado.models.MarcaProduto;
import br.com.projeto.mercado.models.Usuario;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProdutoResponse {

    private Long id;

    private String tipoUnidade;

    private String nome;

    private Boolean ativo;

    private String descricao;

    private Double peso; /* 1000.55 G */

    private Double largura;

    private Double altura;

    private Double profundidade;

    private BigDecimal valorVenda = BigDecimal.ZERO;

    private Integer qtdEstoque = 0;

    private Integer qtdeAlertaEstoque = 0;

    private String linkYoutube;

    private Boolean alertaQtdeEstoque = Boolean.FALSE;

    private Integer qtdeClique = 0;

    private Usuario empresa;

    private CategoriaProduto categoriaProduto = new CategoriaProduto();

    private MarcaProduto marcaProduto = new MarcaProduto();

    private List<ImagemProduto> imagens = new ArrayList<ImagemProduto>();

}
