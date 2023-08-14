package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.response.UnidadeMedidaResponse;
import br.com.projeto.mercado.models.Produto;
import br.com.projeto.mercado.models.UnidadeMedida;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
import br.com.projeto.mercado.models.mapper.UnidadeMedidaMapper;
import br.com.projeto.mercado.repositories.UnidadeMeditaRepository;
import br.com.projeto.mercado.service.UnidadeMedidaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class UnidadeMedidaServiceImpl implements UnidadeMedidaService {

    private UnidadeMeditaRepository unidadeMeditaRepository;
    private UnidadeMedidaMapper unidadeMedidaMapper;

    @Override
    public List<UnidadeMedidaResponse> findAll() {
        log.debug("GET UnidadeMedidaResponse findAll");
        return unidadeMeditaRepository.findAll().stream().map(unidadeMedidaMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public UnidadeMedida buscarOuFalhar(Long id) {
        log.debug("GET id received {} ", id.toString());
        return unidadeMeditaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não existe um cadastro com id: " + id));
    }

}
