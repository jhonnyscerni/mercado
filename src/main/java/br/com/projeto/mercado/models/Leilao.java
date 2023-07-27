package br.com.projeto.mercado.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leilao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_leilao", sequenceName = "seq_leilao", allocationSize = 1, initialValue = 1)
public class Leilao extends Base{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_leilao")
    @EqualsAndHashCode.Include
    private Long id;

    private BigDecimal valorLance;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "usuario_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "usuario_id_fk"))
    private Usuario usuario;


    @ManyToOne(targetEntity = Edital.class)
    @JoinColumn(name = "edital_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "edital_id_fk"))
    private Edital edital;

}
