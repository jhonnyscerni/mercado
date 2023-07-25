package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.filter.EditalFiltro;
import br.com.projeto.mercado.api.response.EditalResponse;
import br.com.projeto.mercado.models.Edital;
import br.com.projeto.mercado.models.Usuario;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
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
        authenticationCurrentUserService.verifyNoticeIsRoleVendorOrAdmin(filter);
        return editalRepository.findAll(new EditalSpecification(filter), pageable).map(editalMapper::toResponse);
    }

    @Override
    public Edital buscarOuFalhar(Long id) {
        log.debug("GET id received {} ", id.toString());
        return editalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não existe um cadastro de edital"+ id));
    }
}
