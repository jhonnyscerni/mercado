package br.com.projeto.mercado.api.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditalArquivoResponse {

    private String nomeArquivo;
    private String descricao;
    private String contentType;
    private Long tamanho;

}