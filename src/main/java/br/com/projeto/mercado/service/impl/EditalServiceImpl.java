package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.filter.EditalFiltro;
import br.com.projeto.mercado.api.response.EditalResponse;
import br.com.projeto.mercado.models.mapper.EditalMapper;
import br.com.projeto.mercado.repositories.EditalRepository;
import br.com.projeto.mercado.repositories.specs.EditalSpecification;
import br.com.projeto.mercado.security.AuthenticationCurrentUserService;
import br.com.projeto.mercado.service.EditalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class EditalServiceImpl implements EditalService {

    private final EditalRepository editalRepository;
    private final EditalMapper editalMapper;
    private final AuthenticationCurrentUserService authenticationCurrentUserService;
    @Override
    public Page<EditalResponse> search(EditalFiltro filter, Pageable pageable) {
        log.debug("GET UserFilter filter received {} ", filter.toString());
        authenticationCurrentUserService.verifyNoticeIsRoleAdmin(filter);
        return editalRepository.findAll(new EditalSpecification(filter), pageable).map(editalMapper::toResponse);
    }
}
