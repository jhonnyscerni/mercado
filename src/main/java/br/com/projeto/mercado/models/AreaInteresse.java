package br.com.projeto.mercado.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "area_interesse")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_area_interesse", sequenceName = "seq_area_interesse", initialValue = 1, allocationSize = 1)
public class AreaInteresse extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_area_interesse")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "Informa o nome da Area de Interesse")
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 60)
    private String descricao;

    @JsonIgnore
    @ManyToOne(targetEntity = Empresa.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private Empresa empresa;

}
