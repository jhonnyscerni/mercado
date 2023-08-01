package br.com.projeto.mercado.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "regiao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_regiao", sequenceName = "seq_regiao", initialValue = 1, allocationSize = 1)
public class Regiao extends Base implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_regiao")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 30)
    private String descricao;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.descricao.toString();
    }
}
