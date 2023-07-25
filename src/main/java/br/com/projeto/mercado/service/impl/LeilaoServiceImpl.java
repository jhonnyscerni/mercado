package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.filter.LeilaoFiltro;
import br.com.projeto.mercado.api.request.LeilaoRequest;
import br.com.projeto.mercado.api.response.LeilaoResponse;
import br.com.projeto.mercado.models.Edital;
import br.com.projeto.mercado.models.Leilao;
import br.com.projeto.mercado.models.Usuario;
import br.com.projeto.mercado.models.mapper.LeilaoMapper;
import br.com.projeto.mercado.repositories.LeilaoRepository;
import br.com.projeto.mercado.repositories.specs.LeilaoSpecification;
import br.com.projeto.mercado.security.AuthenticationCurrentUserService;
import br.com.projeto.mercado.service.EditalService;
import br.com.projeto.mercado.service.LeilaoService;
import br.com.projeto.mercado.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class LeilaoServiceImpl implements LeilaoService {

    private final LeilaoRepository leilaoRepository;
    private final LeilaoMapper leilaoMapper;
    private final AuthenticationCurrentUserService authenticationCurrentUserService;
    private final EditalService editalService;
    private final UsuarioService usuarioService;

    @Override
    public Page<LeilaoResponse> search(LeilaoFiltro filter, Pageable pageable) {
        return leilaoRepository.findAll(new LeilaoSpecification(filter), pageable).map(leilaoMapper::toResponse);
    }

    @Override
    public LeilaoResponse save(Long id, LeilaoRequest leilaoRequest) {
        Long userId = authenticationCurrentUserService.getCurrentUser().getUserId();
        leilaoRequest.setUsuario(usuarioService.buscarOuFalhar(userId));
        leilaoRequest.setEdital(editalService.buscarOuFalhar(id));

        Leilao leilao = leilaoMapper.resquestToEntity(leilaoRequest);
        leilao = leilaoRepository.save(leilao);

        log.debug("POST save leilao saved {} ", leilao.getId());
        log.info("User saved successfully leilao {} ", leilao.getId());
        return leilaoMapper.toResponse(leilao);
    }
}
