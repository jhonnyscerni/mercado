package br.com.projeto.mercado.repositories.specs;

import br.com.projeto.mercado.api.filter.EditalFiltro;
import br.com.projeto.mercado.models.Edital;
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
public class EditalSpecification implements Specification<Edital> {

    private EditalFiltro filtro;

    @Override
    public Predicate toPredicate(Root<Edital> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filtro.isMeusDados()){
            Optional.ofNullable(filtro.getEmpresaId())
                    .ifPresent(p -> predicates.add(criteriaBuilder.equal(root.get("empresa").get("id"), filtro.getEmpresaId())));
        }else {
            Optional.ofNullable(filtro.getEmpresaId())
                    .ifPresent(p -> predicates.add(criteriaBuilder.notEqual(root.get("empresa").get("id"), filtro.getEmpresaId())));
        }
        Optional.ofNullable(filtro.getNumero())
                .ifPresent(p -> predicates.add(criteriaBuilder.equal(root.get("numero"),  filtro.getNumero())));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
