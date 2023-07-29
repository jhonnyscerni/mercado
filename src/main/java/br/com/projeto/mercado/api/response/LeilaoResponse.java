package br.com.projeto.mercado.api.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LeilaoResponse {

    private Long id;

    private BigDecimal valorLance;

    private UsuarioResponse usuario;

    private EditalResponse edital;
}
