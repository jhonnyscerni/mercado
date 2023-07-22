package br.com.projeto.mercado.models;

import br.com.projeto.mercado.models.enums.TipoGrupo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_grupos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_grupo", sequenceName = "seq_grupo", initialValue = 1, allocationSize = 1)
public class Grupo extends Base implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grupo")
    @EqualsAndHashCode.Include
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 30)
    private TipoGrupo nome;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.nome.toString();
    }
}
