package br.com.projeto.mercado.service;


import br.com.projeto.mercado.models.Role;
import br.com.projeto.mercado.models.enums.RoleType;

public interface RoleService {

    Role findByRoleName(RoleType roleType);
}
