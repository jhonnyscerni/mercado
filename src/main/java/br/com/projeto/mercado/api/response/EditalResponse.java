package br.com.projeto.mercado.api.response;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class EditalResponse {

    private Long id;

    private String titulo;

    private Long numero;

    private OffsetDateTime dataInicio;

    private OffsetDateTime dataFim;

    private OffsetDateTime dataExibicao;

    private Long tempoMaximoEntrega;

    private EmpresaResponse empresa;

    private Set<EditalItemResponse> itens;

    private Set<RegiaoResponse> regioes = new HashSet<>();

    private Set<FormaPagamentoResponse> formasPagamento = new HashSet<>();

    private EnderecoResponse endereco;

}
