package br.com.projeto.mercado.api.request;

import br.com.projeto.mercado.models.CategoriaProduto;
import br.com.projeto.mercado.models.Empresa;
import br.com.projeto.mercado.models.MarcaProduto;
import lombok.Data;

@Data
public class ProdutoRequest {

    private String codigoExterno;

    private String nome;

    private String descricao;

    private Empresa empresa;

    private CategoriaProduto categoriaProduto;

    private MarcaProduto marcaProduto;
}
