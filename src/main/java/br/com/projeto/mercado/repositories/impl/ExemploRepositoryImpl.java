package br.com.projeto.mercado.repositories.impl;

import br.com.projeto.mercado.models.Usuario;
import br.com.projeto.mercado.repositories.queries.ExemploRepositoryQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ExemploRepositoryImpl implements ExemploRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Usuario> find(String username) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("from Usuario where 0 = 0 ");

        Map<String, Object> parametros = new HashMap<>();
        // var parametros = new HashMap<String, Object>();

        if (StringUtils.hasLength(username)) {
            jpql.append("and username like :username ");
            parametros.put("username", "%" + username + "%");
        }

        TypedQuery<Usuario> query = manager
                .createQuery(jpql.toString(), Usuario.class);

        parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

        return query.getResultList();
    }

    @Override
    public List<Usuario> findCriteria(String username) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(Usuario.class);
        Root<Usuario> root = criteriaQuery.from(Usuario.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(username)) {
            predicates.add(builder.like(root.get("username"), "%" + username + "%"));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Usuario> restauranteTypedQuery = manager.createQuery(criteriaQuery);

        return restauranteTypedQuery.getResultList();

    }
}
