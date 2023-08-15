package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.response.RegiaoResponse;
import br.com.projeto.mercado.api.response.UnidadeMedidaResponse;
import br.com.projeto.mercado.models.mapper.RegiaoMapper;
import br.com.projeto.mercado.repositories.RegiaoRepository;
import br.com.projeto.mercado.service.RegiaoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class RegiaoServiceImpl implements RegiaoService {

    private final RegiaoRepository regiaoRepository;
    private final RegiaoMapper regiaoMapper;

    @Override
    public List<RegiaoResponse> search(Long editalId) {
        return regiaoRepository.findByEditalId(editalId).stream().map(regiaoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<RegiaoResponse> findAll() {
        log.debug("GET RegiaoResponse findAll");
        return regiaoRepository.findAll().stream().map(regiaoMapper::toResponse).collect(Collectors.toList());
    }
}
