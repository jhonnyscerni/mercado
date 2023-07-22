package br.com.projeto.mercado.models;

import lombok.*;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_empresas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_empresa", sequenceName = "seq_empresa", allocationSize = 1, initialValue = 1)
public class Empresa extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresa")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String razaoSocial;

    @Column(nullable = false, unique = true, length = 50)
    private String nomeFantasia;

    @CNPJ(message = "Cnpj está inválido")
    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String inscEstadual;

    private String inscMunicipal;

    private String categoria;

    private String telefone;

    @OneToMany(mappedBy = "empresa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    @ManyToOne(targetEntity = Endereco.class, cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_id_fk"))
    private Endereco endereco = new Endereco();
}
