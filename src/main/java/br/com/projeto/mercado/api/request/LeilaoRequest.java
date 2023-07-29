package br.com.projeto.mercado.api.request;

import br.com.projeto.mercado.models.Edital;
import br.com.projeto.mercado.models.Usuario;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LeilaoRequest {

    private BigDecimal valorLance;

    private Usuario usuario;

    private Edital edital;
}
