package br.com.projeto.mercado.models;

import lombok.*;

import java.io.Serializable;

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


    @ManyToOne(targetEntity = Usuario.class)
    // TODO : Retirando nullable = false, repois retornar ele
    @JoinColumn(name = "usuario_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "usuario_id_fk"))
    private Usuario empresa;

}