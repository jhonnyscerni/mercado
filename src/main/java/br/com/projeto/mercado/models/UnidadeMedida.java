package br.com.projeto.mercado.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unidade_medida")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_unidade_medida", sequenceName = "seq_unidade_medida", initialValue = 1, allocationSize = 1)
public class UnidadeMedida extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_unidade_medida")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "Informa o nome da Unidade de Medida")
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 60)
    private String descricao;

}
