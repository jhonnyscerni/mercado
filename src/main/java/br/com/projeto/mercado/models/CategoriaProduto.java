package br.com.projeto.mercado.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoria_produto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", allocationSize = 1, initialValue = 1)
public class CategoriaProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome_desc", nullable = false)
    private String nomeDesc;


    @ManyToOne(targetEntity = Usuario.class)
    // TODO : Retirando nullable = false, repois retornar ele
    @JoinColumn(name = "usuario_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "usuario_id_fk"))
    private Usuario empresa = new Usuario();

}