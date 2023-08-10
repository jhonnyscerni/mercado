package br.com.projeto.mercado.models;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "forma_pagamento")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_forma_pagamento", sequenceName = "seq_forma_pagamento", initialValue = 1, allocationSize = 1)
public class FormaPagamento extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_forma_pagamento")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "Informa o nome da forma de Pagamento")
    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @UpdateTimestamp
    private OffsetDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Edital edital;

}
