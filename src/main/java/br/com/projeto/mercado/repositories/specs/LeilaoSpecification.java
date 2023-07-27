package br.com.projeto.mercado.repositories.specs;

import br.com.projeto.mercado.api.filter.LeilaoFiltro;
import br.com.projeto.mercado.models.Leilao;
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
public class LeilaoSpecification implements Specification<Leilao> {

    private LeilaoFiltro filtro;
    @Override
    public Predicate toPredicate(Root<Leilao> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        Optional.ofNullable(filtro.getEditalId())
                .ifPresent(p -> predicates.add(criteriaBuilder.equal(root.get("edital").get("id"), filtro.getEditalId())));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
