package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.filter.ProdutoFiltro;
import br.com.projeto.mercado.api.request.ProdutoRequest;
import br.com.projeto.mercado.api.response.ProdutoResponse;
import br.com.projeto.mercado.models.Empresa;
import br.com.projeto.mercado.models.Produto;
import br.com.projeto.mercado.models.exceptions.EntityInUseException;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
import br.com.projeto.mercado.models.mapper.ProdutoMapper;
import br.com.projeto.mercado.repositories.EmpresaRepository;
import br.com.projeto.mercado.repositories.ProdutoRepository;
import br.com.projeto.mercado.repositories.specs.ProdutoSpecification;
import br.com.projeto.mercado.security.AuthenticationCurrentUserService;
import br.com.projeto.mercado.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private static final String MSG_EM_USO
            = "Usuário de código %d não pode ser removida, pois está em uso";

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;
    private final AuthenticationCurrentUserService authenticationCurrentUserService;
    private final EmpresaRepository empresaRepository;

    @Override
    public Page<ProdutoResponse> search(ProdutoFiltro filter, Pageable pageable) {
        log.debug("GET ProdutoFiltro filter received {} ", filter.toString());
        authenticationCurrentUserService.verifyProductIsRoleVendorOrAdmin(filter);

        return produtoRepository.findAll(new ProdutoSpecification(filter), pageable).map(produtoMapper::toResponse);

    }

    @Override
    public void delete(Long id) {
        try {
            produtoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(id);

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(MSG_EM_USO, id));
        }
    }

    @Override
    public Produto buscarOuFalhar(Long id) {
        log.debug("GET id received {} ", id.toString());
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não existe um cadastro com id: " + id));
    }

    @Override
    public ProdutoResponse findByIdProdutoResponse(Long id) {
        log.debug("GET UserResponse Long id received {} ", id.toString());
        Produto produto = buscarOuFalhar(id);
        return produtoMapper.toResponse(produto);
    }

    @Override
    public ProdutoResponse save(ProdutoRequest produtoRequest) {

        Long empresaId = authenticationCurrentUserService.getCurrentUser().getEmpresaId();
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EntityNotFoundException("Não existe um cadastro com id: " + empresaId));
        produtoRequest.setEmpresa(empresa);

        Produto produto = produtoMapper.resquestToEntity(produtoRequest);

        produto = produtoRepository.save(produto);
        log.debug("POST save produtoId saved {} ", produto.getId());
        log.info("User saved successfully produtoId {} ", produto.getId());

        return produtoMapper.toResponse(produto);
    }

    @Override
    public ProdutoResponse update(Long id, ProdutoRequest produtoRequest) {
        log.debug("PUT id received {} ", id.toString());
        log.debug("PUT ProdutoRequest produtoRequest received {} ", produtoRequest.toString());
        Produto produto = buscarOuFalhar(id);

        Long empresaId = authenticationCurrentUserService.getCurrentUser().getEmpresaId();
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EntityNotFoundException("Não existe um cadastro com id: " + empresaId));

        produtoRequest.setEmpresa(empresa);

        produtoMapper.update(produto, produtoRequest);

        Produto save = produtoRepository.save(produto);
        log.debug("PUT update produtoId saved {} ", produto.getId());
        log.info("User update successfully produtoId {} ", produto.getId());
        return produtoMapper.toResponse(save);
    }

}
