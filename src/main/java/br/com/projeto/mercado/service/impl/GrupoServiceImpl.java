package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.response.GrupoResponse;
import br.com.projeto.mercado.models.Grupo;
import br.com.projeto.mercado.models.enums.TipoGrupo;
import br.com.projeto.mercado.models.exceptions.BusinessException;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
import br.com.projeto.mercado.models.mapper.GrupoMapper;
import br.com.projeto.mercado.repositories.GrupoRepository;
import br.com.projeto.mercado.service.GrupoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    @Override
    public Grupo findByRoleName(TipoGrupo tipoGrupo) {
        return grupoRepository.findByNome(tipoGrupo).orElseThrow(() -> new BusinessException("Error: Grupo não encontrado"));
    }

    @Override
    public Grupo buscarOuFalhar(Long id) {
        log.debug("GET Long roleId received {} ", id.toString());
        return grupoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Error: Não há registro de grupo" + id));
    }


    @Override
    public List<GrupoResponse> findAll() {
        log.debug("GET GrupoResponse findAll");
        return grupoRepository.findAll().stream().map(grupoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public GrupoResponse findByIdGrupoResponse(Long id) {
        log.debug("GET GrupoResponse Long id received {} ", id.toString());
        Grupo role = buscarOuFalhar(id);
        return grupoMapper.toResponse(role);
    }

}
