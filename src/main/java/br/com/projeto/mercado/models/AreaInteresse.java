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
@Table(name = "area_interesse")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_area_interesse", sequenceName = "seq_area_interesse", initialValue = 1, allocationSize = 1)
public class AreaInteresse extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_area_interesse")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 60)
    private String descricao;

}
