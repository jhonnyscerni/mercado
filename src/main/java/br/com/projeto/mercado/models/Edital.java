package br.com.projeto.mercado.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "edital")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_edital", sequenceName = "seq_edital", allocationSize = 1, initialValue = 1)
public class Edital extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_edital")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "data_inicio")
    private OffsetDateTime dataInicio;

    @Column(name = "data_fim")
    private OffsetDateTime dataFim;

    @Column(name = "data_exibe")
    private OffsetDateTime dataExibicao;

    @Column(name = "tempo_maximo_entrega")
    private Long tempoMaximoEntrega;

    @ManyToOne(targetEntity = Empresa.class)
    @JoinColumn(name = "empresa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id_fk"))
    private Empresa empresa;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "edital_itens",
            joinColumns = @JoinColumn(name = "edital_id"),
            inverseJoinColumns = @JoinColumn(name = "edital_item_id"))
    private Set<EditalItem> editalItens = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "regioes",
            joinColumns = @JoinColumn(name = "edital_id"),
            inverseJoinColumns = @JoinColumn(name = "regiao_id"))
    private Set<Regiao> regioes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "formasPagamento",
            joinColumns = @JoinColumn(name = "edital_id"),
            inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private Set<FormaPagamento> formasPagamento = new HashSet<>();

    @ManyToOne(targetEntity = Endereco.class)
    @JoinColumn(name = "endereco_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_id_fk"))
    private Endereco endereco;

    //TODO. criar parametro para definição de critério de vencedor
    //private CriterioVencedor criterioVencedor

}
