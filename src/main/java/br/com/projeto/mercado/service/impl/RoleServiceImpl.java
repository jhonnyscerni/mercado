package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.models.Role;
import br.com.projeto.mercado.models.enums.RoleType;
import br.com.projeto.mercado.models.exceptions.BusinessException;
import br.com.projeto.mercado.repositories.RoleRepository;
import br.com.projeto.mercado.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByRoleName(RoleType roleType) {
        return roleRepository.findByRoleName(roleType).orElseThrow(() -> new BusinessException("Error: Role is Not Found."));
    }
}
