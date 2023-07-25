package br.com.projeto.mercado.api.response;

import lombok.Data;

@Data
public class LeilaoResponse {

    private Long id;

    private UsuarioResponse empresa;

    private EditalResponse edital;
}
