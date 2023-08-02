package br.com.projeto.mercado.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "editar_item")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_editar_item", sequenceName = "seq_editar_item", initialValue = 1, allocationSize = 1)
public class EditalItem extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_unidade_medida")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String especificacao;

    @Column(nullable = false)
    private String observacao;

    @ManyToOne(targetEntity = Produto.class)
    @JoinColumn(name = "produto_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_id_fk"))
    private Produto produto;

    @ManyToOne(targetEntity = UnidadeMedida.class)
    @JoinColumn(name = "unidadeMedida_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "unidadeMedida_id_fk"))
    private UnidadeMedida unidadeMedida;

    @Column(nullable = false)
    private Double quantidade;

    @Column(nullable = false)
    private Boolean propostaParcial = Boolean.FALSE;
    

}
