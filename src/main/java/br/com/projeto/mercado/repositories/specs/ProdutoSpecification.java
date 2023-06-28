package br.com.projeto.mercado.repositories.specs;

import br.com.projeto.mercado.api.filter.ProdutoFiltro;
import br.com.projeto.mercado.models.Produto;
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
public class ProdutoSpecification implements Specification<Produto> {

    private ProdutoFiltro produtoFiltro;

    @Override
    public Predicate toPredicate(Root<Produto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        Optional.ofNullable(produtoFiltro.getNome())
                .ifPresent(p -> predicates.add(criteriaBuilder.like(root.get("nome"), "%" + produtoFiltro.getNome() + "%")));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
