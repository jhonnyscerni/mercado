package br.com.projeto.mercado.api.response;

import br.com.projeto.mercado.models.enums.TipoEndereco;
import lombok.Data;

@Data
public class EnderecoResponse {

    private Long id;

    private String ruaLogra;

    private String cep;

    private String numero;

    private String complemento;

    private String bairro;

    private String uf;

    private String cidade;

    private String estado;

    private TipoEndereco tipoEndereco;
}
