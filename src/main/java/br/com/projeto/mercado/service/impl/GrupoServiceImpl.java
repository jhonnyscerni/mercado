package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.models.Grupo;
import br.com.projeto.mercado.models.enums.TipoGrupo;
import br.com.projeto.mercado.models.exceptions.BusinessException;
import br.com.projeto.mercado.repositories.GrupoRepository;
import br.com.projeto.mercado.service.GrupoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository grupoRepository;

    @Override
    public Grupo findByRoleName(TipoGrupo tipoGrupo) {
        return grupoRepository.findByNome(tipoGrupo).orElseThrow(() -> new BusinessException("Error: Role is Not Found."));
    }
}
