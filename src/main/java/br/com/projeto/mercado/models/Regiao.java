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
@Table(name = "regiao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_regiao", sequenceName = "seq_regiao", initialValue = 1, allocationSize = 1)
public class Regiao extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_regiao")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "Informa o nome da Regiao")
    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Edital edital;

}
