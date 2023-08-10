package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.response.EditalItemResponse;
import br.com.projeto.mercado.models.mapper.EditalItemMapper;
import br.com.projeto.mercado.repositories.EditalItemRepository;
import br.com.projeto.mercado.service.EditalItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EditalItemServiceImpl implements EditalItemService {

    private final EditalItemRepository editalItemRepository;
    private final EditalItemMapper editalItemMapper;

    @Override
    public List<EditalItemResponse> search(Long editalId) {
        return editalItemRepository.findByEditalId(editalId).stream().map(editalItemMapper::toResponse).collect(Collectors.toList());
    }
}
