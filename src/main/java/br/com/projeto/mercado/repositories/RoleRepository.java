package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.Role;
import br.com.projeto.mercado.models.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleType name);
}
