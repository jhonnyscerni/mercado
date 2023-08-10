package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.response.FormaPagamentoResponse;
import br.com.projeto.mercado.models.mapper.FormaPagamentoMapper;
import br.com.projeto.mercado.repositories.FormaPagamentoRepository;
import br.com.projeto.mercado.service.FormaPagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FormaPagamentoServiceImpl implements FormaPagamentoService {

    private final FormaPagamentoRepository formaPagamentoRepository;
    private final FormaPagamentoMapper formaPagamentoMapper;

    @Override
    public List<FormaPagamentoResponse> search(Long editalId) {
        return formaPagamentoRepository.findByEditalId(editalId).stream().map(formaPagamentoMapper::toResponse).collect(Collectors.toList());
    }
}
