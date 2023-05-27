package br.com.projeto.mercado.repositories.specs;

import br.com.projeto.mercado.api.filter.UsuarioFiltro;
import br.com.projeto.mercado.models.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UsuarioSpecification implements Specification<Usuario> {

    private UsuarioFiltro usuarioFiltro;

    @Override
    public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        Optional.ofNullable(usuarioFiltro.getUsername())
                .ifPresent(p -> predicates.add(criteriaBuilder.like(root.get("username"), "%" + usuarioFiltro.getUsername() + "%")));
        Optional.ofNullable(usuarioFiltro.getEmail())
                .ifPresent(p -> predicates.add(criteriaBuilder.like(root.get("email"), "%" + usuarioFiltro.getEmail() + "%")));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
