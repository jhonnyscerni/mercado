package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.response.FormaPagamentoResponse;
import br.com.projeto.mercado.models.mapper.FormaPagamentoMapper;
import br.com.projeto.mercado.repositories.FormaPagamentoRepository;
import br.com.projeto.mercado.service.FormaPagamentoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class FormaPagamentoServiceImpl implements FormaPagamentoService {

    private final FormaPagamentoRepository formaPagamentoRepository;
    private final FormaPagamentoMapper formaPagamentoMapper;

    @Override
    public List<FormaPagamentoResponse> search(Long editalId) {
        return formaPagamentoRepository.findByEditalId(editalId).stream().map(formaPagamentoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<FormaPagamentoResponse> findAll() {
        log.debug("GET FormaPagamentoResponse findAll");
        return formaPagamentoRepository.findAll().stream().map(formaPagamentoMapper::toResponse).collect(Collectors.toList());
    }
}
