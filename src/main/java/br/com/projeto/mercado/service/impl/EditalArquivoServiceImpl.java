package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.response.EditalArquivoResponse;
import br.com.projeto.mercado.models.EditalArquivo;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
import br.com.projeto.mercado.models.mapper.EditalArquivoMapper;
import br.com.projeto.mercado.repositories.EditalArquivoRepository;
import br.com.projeto.mercado.repositories.EditalRepository;
import br.com.projeto.mercado.service.EditalArquivoService;
import br.com.projeto.mercado.service.storage.ArquivoStorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class EditalArquivoServiceImpl implements EditalArquivoService {

    private final EditalRepository editalRepository;

    private final EditalArquivoRepository editalArquivoRepository;

    private final ArquivoStorageService arquivoStorageService;

    private final EditalArquivoMapper editalArquivoMapper;

    @Override
    public List<EditalArquivoResponse> findAll() {
        log.debug("GET EditalArquivoResponse findAll");
        return editalArquivoRepository.findAll().stream().map(editalArquivoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EditalArquivoResponse salvar(EditalArquivo arquivo, InputStream dadosArquivo) {
        Long editalId = arquivo.getEdital().getId();
        String nomeNovoArquivo = arquivoStorageService.gerarNomeArquivo(arquivo.getNomeArquivo());
        String nomeArquivoExistente = null;

        Optional<EditalArquivo> optionalEditalArquivo = editalArquivoRepository
                .findEditalArquivoById(editalId);

        if (optionalEditalArquivo.isPresent()) {
            nomeArquivoExistente = optionalEditalArquivo.get().getNomeArquivo();
            editalArquivoRepository.delete(optionalEditalArquivo.get());
        }

        arquivo.setNomeArquivo(nomeNovoArquivo);
        arquivo =  editalArquivoRepository.save(arquivo);
        editalRepository.flush();

        ArquivoStorageService.NovoArquivo novoArquivo = ArquivoStorageService.NovoArquivo.builder()
                .nomeArquivo(arquivo.getNomeArquivo())
                .contentType(arquivo.getContentType())
                .inputStream(dadosArquivo)
                .build();

        arquivoStorageService.substituir(nomeArquivoExistente, novoArquivo);

        return editalArquivoMapper.toResponse(arquivo);
    }

    @Override
    public EditalArquivoResponse findEditalArquivoById(Long id) {
        log.debug("GET id received {} ", id.toString());
        return editalArquivoMapper.toResponse(buscarOuFalhar(id));
    }

    @Override
    public EditalArquivo buscarOuFalhar(Long id){
        return editalArquivoRepository.findEditalArquivoById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não existe um cadastro com id: " + id));
    }

    @Override
    public void excluir(Long editalId) {
        EditalArquivo arquivo = this.buscarOuFalhar(editalId);

        editalArquivoRepository.delete(arquivo);
        editalArquivoRepository.flush();

        arquivoStorageService.remover(arquivo.getNomeArquivo());
    }

}
