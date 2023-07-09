package br.com.projeto.mercado.models;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marca_produto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
public class MarcaProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "Informa o nome ou descrição da marca")
    @Column(nullable = false)
    private String nomeDesc;


}