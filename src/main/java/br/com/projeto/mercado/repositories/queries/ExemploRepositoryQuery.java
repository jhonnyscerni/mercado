package br.com.projeto.mercado.repositories.queries;

import br.com.projeto.mercado.models.Usuario;

import java.util.List;

/**
 *  Caso queira fazer a consulta sem o Specification este e um exemplo como fazer como JPQL e Criteria
 *  dessa forma so adicionamos no UsuarioRepositorio essa interface
 *  Exemplo :
 *  public interface UsuarioRepository extends JpaRepository<Usuario, Long>, ExemploRepositoryQuery, JpaSpecificationExecutor<Usuario>
 */


public interface ExemploRepositoryQuery {

    List<Usuario> find(String username);

    List<Usuario> findCriteria(String username);

}
