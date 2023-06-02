package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.request.MarcaProdutoRequest;
import br.com.projeto.mercado.api.response.MarcaProdutoResponse;
import br.com.projeto.mercado.models.MarcaProduto;
import br.com.projeto.mercado.models.MarcaProduto;
import br.com.projeto.mercado.models.MarcaProduto;
import br.com.projeto.mercado.models.exceptions.ConflictException;
import br.com.projeto.mercado.models.exceptions.EntityInUseException;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
import br.com.projeto.mercado.models.mapper.MarcaProdutoMapper;
import br.com.projeto.mercado.repositories.MarcaProdutoRepository;
import br.com.projeto.mercado.service.MarcaProdutoService;
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
public class MarcaProdutoServiceImpl implements MarcaProdutoService {

    private static final String MSG_EXCEPTION
            = "Marca de código %d não pode ser removida, pois está em uso";

    private MarcaProdutoRepository marcaProdutoRepository;
    private MarcaProdutoMapper marcaProdutoMapper;

    @Override
    public MarcaProduto buscarOuFalhar(Long id) {
        log.debug("GET Long roleId received {} ", id.toString());
        return marcaProdutoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Error: Não há registro de Marca Produto" + id));
    }

    @Override
    public List<MarcaProdutoResponse> findAll() {
        log.debug("GET MarcaProdutoResponse findAll");
        return marcaProdutoRepository.findAll().stream().map(marcaProdutoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public MarcaProdutoResponse findByIdMarcaProdutoResponse(Long id) {
        log.debug("GET GrupoResponse Long id received {} ", id.toString());
        MarcaProduto marcaProduto = buscarOuFalhar(id);
        return marcaProdutoMapper.toResponse(marcaProduto);
    }

    @Override
    public void delete(Long id) {
        try {
            marcaProdutoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(id);

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(MSG_EXCEPTION, id));
        }
    }

    @Override
    public MarcaProdutoResponse save(MarcaProdutoRequest marcaProdutoRequest) {
        log.debug("POST MarcaProdutoRequest marcaProdutoRequest received {} ", marcaProdutoRequest.toString());

        MarcaProduto marcaProduto = marcaProdutoMapper.resquestToEntity(marcaProdutoRequest);

        if (marcaProduto.getId() == null && marcaProdutoRepository.findByNomeDesc(marcaProduto.getNomeDesc()).isPresent()) {
            log.warn("NomeDesc {} is Already Taken ", marcaProdutoRequest.getNomeDesc());
            throw new ConflictException(
                    String.format("Error: NomeDesc is Already Taken! %s ", marcaProdutoRequest.getNomeDesc()));
        }

        marcaProduto = marcaProdutoRepository.save(marcaProduto);
        log.debug("POST save Id saved {} ", marcaProduto.getId());
        log.info("saved successfully Id {} ", marcaProduto.getId());

        return marcaProdutoMapper.toResponse(marcaProduto);
    }

    @Override
    public MarcaProdutoResponse update(Long id, MarcaProdutoRequest marcaProdutoRequest) {
        log.debug("PUT id received {} ", id.toString());
        log.debug("PUT MarcaProdutoRequest marcaProdutoRequest received {} ", marcaProdutoRequest.toString());
        MarcaProduto marcaProduto = buscarOuFalhar(id);

        existsByMarcaNomeDesc(marcaProduto, marcaProdutoRequest.getNomeDesc());

        marcaProdutoMapper.update(marcaProduto, marcaProdutoRequest);

        MarcaProduto save = marcaProdutoRepository.save(marcaProduto);
        log.debug("PUT update id saved {} ", marcaProduto.getId());
        log.info("MarcaProduto update successfully id {} ", marcaProduto.getId());
        return marcaProdutoMapper.toResponse(save);
    }

    private void existsByMarcaNomeDesc(MarcaProduto marcaProduto, String nomeDesc) {
        Optional<MarcaProduto> optionalMarcaProduto = marcaProdutoRepository.findByNomeDesc(nomeDesc);

        if (optionalMarcaProduto.isPresent() && !optionalMarcaProduto.get().equals(marcaProduto)) {
            log.warn("NomeDesc {} is Already Taken ", optionalMarcaProduto.get().getNomeDesc());
            throw new ConflictException(
                    String.format("Error: NomeDesc is Already Taken! %s ", optionalMarcaProduto.get().getNomeDesc()));
        }
    }

}
