package br.com.projeto.mercado.models;

import br.com.projeto.mercado.models.enums.StatusUsuario;
import br.com.projeto.mercado.models.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuarios")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @EqualsAndHashCode.Include
    private Long id;

    private String username;

    @Column(nullable = false, unique = true, length = 255)
    private String razaoSocial;

    @Column(nullable = false, unique = true, length = 50)
    private String nomeFantasia;

    @CNPJ(message = "Cnpj está inválido")
    @Column(nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    @Column(nullable = false)
    private String inscEstadual;


    private String inscMunicipal;

    private String categoria;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    // Podemos Criar Classe Pessoa e fazer Herança com os tipos
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Enumerated(EnumType.STRING)
    private StatusUsuario statusUsuario;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "TB_USUARIOS_GRUPOS",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private Set<Grupo> grupos = new HashSet<>();
}
