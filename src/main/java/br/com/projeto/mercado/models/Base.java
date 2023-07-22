package br.com.projeto.mercado.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Base{

    @CreatedDate
    @Column(nullable = false)
    private Date criacao;

    private Date modificacao;

    private boolean ativo;

    private Long codigoUsuarioCriacao;

    private Long codigoUsuarioModificacao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return ativo == base.ativo && Objects.equals(criacao, base.criacao) && Objects.equals(modificacao, base.modificacao) && Objects.equals(codigoUsuarioCriacao, base.codigoUsuarioCriacao) && Objects.equals(codigoUsuarioModificacao, base.codigoUsuarioModificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criacao, modificacao, ativo, codigoUsuarioCriacao, codigoUsuarioModificacao);
    }
}
