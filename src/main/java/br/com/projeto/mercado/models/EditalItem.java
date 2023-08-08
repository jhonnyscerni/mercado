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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "edital_item")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_editar_item", sequenceName = "seq_editar_item", initialValue = 1, allocationSize = 1)
public class EditalItem extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_editar_item")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String especificacao;

    private String observacao;

    @ManyToOne(targetEntity = Produto.class)
    @JoinColumn(name = "produto_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_id_fk"))
    private Produto produto;

    @ManyToOne(targetEntity = UnidadeMedida.class)
    @JoinColumn(name = "unidadeMedida_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "unidadeMedida_id_fk"))
    private UnidadeMedida unidadeMedida;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Edital edital;

    @Column(nullable = false)
    private Double quantidade;

    private Boolean propostaParcial = Boolean.FALSE;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private Double largura;

    @Column(nullable = false)
    private Double altura;

    @Column(nullable = false)
    private Double profundidade;

    @Column(nullable = false)
    private BigDecimal valorMaximo = BigDecimal.ZERO;

}
