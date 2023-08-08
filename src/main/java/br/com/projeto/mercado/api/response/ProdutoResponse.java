package br.com.projeto.mercado.api.response;

import br.com.projeto.mercado.models.Empresa;
import br.com.projeto.mercado.models.ImagemProduto;
import br.com.projeto.mercado.models.MarcaProduto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProdutoResponse {

    private Long id;

    private String codigoExterno;

    private String nome;

    //private Boolean ativo;

    private String descricao;

    private Empresa empresa;

    private CategoriaProdutoResponse categoriaProduto = new CategoriaProdutoResponse();

    private MarcaProdutoResponse marcaProduto = new MarcaProdutoResponse();

    private List<ImagemProduto> imagens = new ArrayList<ImagemProduto>();

}
