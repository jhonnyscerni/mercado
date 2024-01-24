package br.com.projeto.mercado.models;

import br.com.projeto.mercado.models.enums.StatusUsuario;
import br.com.projeto.mercado.models.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuarios")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @CPF
    private String cpf;

    private String username;

    @Email
    @Column(nullable = false)
    private String email;

    private String telefone;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    // Podemos Criar Classe Pessoa e fazer Herança com os tipos
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Enumerated(EnumType.STRING)
    private StatusUsuario statusUsuario;

    @JsonIgnore
    @ManyToOne(targetEntity = Empresa.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private Empresa empresa;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_USUARIOS_GRUPOS",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private Set<Grupo> grupos = new HashSet<>();
}
