package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.request.CategoriaProdutoRequest;
import br.com.projeto.mercado.api.response.CategoriaProdutoResponse;
import br.com.projeto.mercado.models.CategoriaProduto;
import br.com.projeto.mercado.models.exceptions.ConflictException;
import br.com.projeto.mercado.models.exceptions.EntityInUseException;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
import br.com.projeto.mercado.models.mapper.CategoriaProdutoMapper;
import br.com.projeto.mercado.repositories.CategoriaProdutoRepository;
import br.com.projeto.mercado.service.CategoriaProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class CategoriaProdutoServiceImpl implements CategoriaProdutoService {

    private static final String MSG_EXCEPTION
            = "Categoria de código %d não pode ser removida, pois está em uso";

    private final CategoriaProdutoRepository categoriaProdutoRepository;
    private final CategoriaProdutoMapper categoriaProdutoMapper;

    @Override
    public CategoriaProduto buscarOuFalhar(Long id) {
        log.debug("GET Long roleId received {} ", id.toString());
        return categoriaProdutoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Error: Não há registro de categoria Produto" + id));
    }

    @Override
    public List<CategoriaProdutoResponse> findAll() {
        log.debug("GET CategoriaProdutoResponse findAll");
        return categoriaProdutoRepository.findAll().stream().map(categoriaProdutoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public CategoriaProdutoResponse findByIdCategoriaProdutoResponse(Long id) {
        log.debug("GET GrupoResponse Long id received {} ", id.toString());
        CategoriaProduto categoriaProduto = buscarOuFalhar(id);
        return categoriaProdutoMapper.toResponse(categoriaProduto);
    }

    @Override
    public void delete(Long id) {
        try {
            categoriaProdutoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(id);

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(MSG_EXCEPTION, id));
        }
    }

    @Override
    public CategoriaProdutoResponse save(CategoriaProdutoRequest categoriaProdutoRequest) {
        log.debug("POST CategoriaProdutoRequest categoriaProdutoRequest received {} ", categoriaProdutoRequest.toString());

        // TODO : Verificar se Criamos um novo DTO (CategoriaProdutoCreateRequest) para setar o usuario Empresa
        CategoriaProduto categoriaProduto = categoriaProdutoMapper.resquestToEntity(categoriaProdutoRequest);

        if (categoriaProduto.getId() == null && categoriaProdutoRepository.findByNomeDesc(categoriaProduto.getNomeDesc()).isPresent()) {
            log.warn("NomeDesc {} is Already Taken ", categoriaProdutoRequest.getNomeDesc());
            throw new ConflictException(
                    String.format("Error: NomeDesc is Already Taken! %s ", categoriaProdutoRequest.getNomeDesc()));
        }

        categoriaProduto = categoriaProdutoRepository.save(categoriaProduto);
        log.debug("POST save Id saved {} ", categoriaProduto.getId());
        log.info("saved successfully Id {} ", categoriaProduto.getId());

        return categoriaProdutoMapper.toResponse(categoriaProduto);
    }

    @Override
    public CategoriaProdutoResponse update(Long id, CategoriaProdutoRequest categoriaProdutoRequest) {
        log.debug("PUT id received {} ", id.toString());
        log.debug("PUT CategoriaProdutoRequest categoriaProdutoRequest received {} ", categoriaProdutoRequest.toString());
        CategoriaProduto categoriaProduto = buscarOuFalhar(id);

        existsByCategoriaNomeDesc(categoriaProduto, categoriaProdutoRequest.getNomeDesc());

        // TODO : Verificar se Criamos um novo DTO (CategoriaProdutoUpdateRequest) para setar o usuario Empresa
        categoriaProdutoMapper.update(categoriaProduto, categoriaProdutoRequest);

        CategoriaProduto save = categoriaProdutoRepository.save(categoriaProduto);
        log.debug("PUT update id saved {} ", categoriaProduto.getId());
        log.info("CategoriaProduto update successfully id {} ", categoriaProduto.getId());
        return categoriaProdutoMapper.toResponse(save);
    }

    @Override
    public void existsByCategoriaNomeDesc(CategoriaProduto categoriaProduto, String nomeDesc) {
        Optional<CategoriaProduto> optionalCategoriaProduto = categoriaProdutoRepository.findByNomeDesc(nomeDesc);

        if (optionalCategoriaProduto.isPresent() && !optionalCategoriaProduto.get().equals(categoriaProduto)) {
            log.warn("NomeDesc {} is Already Taken ", optionalCategoriaProduto.get().getNomeDesc());
            throw new ConflictException(
                    String.format("Error: NomeDesc is Already Taken! %s ", optionalCategoriaProduto.get().getNomeDesc()));
        }
    }
}
