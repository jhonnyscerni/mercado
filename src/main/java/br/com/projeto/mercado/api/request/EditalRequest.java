package br.com.projeto.mercado.api.request;

import br.com.projeto.mercado.models.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class EditalRequest {

    private String titulo;

    private Long numero;

    private OffsetDateTime dataInicio;

    private OffsetDateTime dataFim;

    private OffsetDateTime dataExibicao;

    private Long tempoMaximoEntrega;

    private Empresa empresa;

    private Set<EditalItem> itens = new HashSet<>();

    private Set<Regiao> regioes = new HashSet<>();

    private Set<FormaPagamento> formasPagamento = new HashSet<>();

    private Endereco endereco;

}
