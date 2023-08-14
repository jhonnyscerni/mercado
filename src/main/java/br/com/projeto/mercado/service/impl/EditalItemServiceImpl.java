package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.request.ItemEditalRequest;
import br.com.projeto.mercado.api.response.EditalItemResponse;
import br.com.projeto.mercado.models.Edital;
import br.com.projeto.mercado.models.EditalItem;
import br.com.projeto.mercado.models.Produto;
import br.com.projeto.mercado.models.UnidadeMedida;
import br.com.projeto.mercado.models.exceptions.EntityInUseException;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
import br.com.projeto.mercado.models.mapper.EditalItemMapper;
import br.com.projeto.mercado.repositories.EditalItemRepository;
import br.com.projeto.mercado.service.EditalItemService;
import br.com.projeto.mercado.service.EditalService;
import br.com.projeto.mercado.service.ProdutoService;
import br.com.projeto.mercado.service.UnidadeMedidaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class EditalItemServiceImpl implements EditalItemService {

    private static final String MSG_EXCEPTION
            = "Item do Edital de código %d não pode ser removida, pois está em uso";

    private final EditalItemRepository editalItemRepository;
    private final EditalItemMapper editalItemMapper;
    private final EditalService editalService;
    private final ProdutoService produtoService;
    private final UnidadeMedidaService unidadeMedidaService;

    @Override
    public List<EditalItemResponse> search(Long editalId) {
        return editalItemRepository.findByEditalId(editalId).stream().map(editalItemMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        try {
            editalItemRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(id);

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(MSG_EXCEPTION, id));
        }
    }

    @Override
    public EditalItemResponse saveItemEdital(Long editalId, ItemEditalRequest itemEditalRequest) {


        EditalItem editalItem = editalItemMapper.resquestToEntity(itemEditalRequest);

        Edital edital = editalService.buscarOuFalhar(editalId);
        Produto produto = produtoService.buscarOuFalhar(itemEditalRequest.getProdutoId());
        UnidadeMedida unidadeMedida = unidadeMedidaService.buscarOuFalhar(itemEditalRequest.getUnidadeMedidaId());

        editalItem.setProduto(produto);
        editalItem.setEdital(edital);
        editalItem.setUnidadeMedida(unidadeMedida);

        editalItem = editalItemRepository.save(editalItem);

        log.debug("POST save editalItem saved {} ", editalItem.getId());
        log.info("User saved successfully editalItem {} ", editalItem.getId());
        return editalItemMapper.toResponse(editalItem);
    }
}
