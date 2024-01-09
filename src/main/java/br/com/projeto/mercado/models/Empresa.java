package br.com.projeto.mercado.models;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
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

    @Email
    private String emailResponsavel;

    private String telefoneResponsavel;

    private String nomeResponsavel;

    private String homepage;

    @ManyToOne(targetEntity = AreaInteresse.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "area_interesse_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "area_interesse_id_fk"))
    private Set<AreaInteresse> areaInteresses = new HashSet<>();

    @OneToMany(mappedBy = "empresa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    @ManyToOne(targetEntity = Endereco.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_id_fk"))
    private Endereco endereco = new Endereco();
}
