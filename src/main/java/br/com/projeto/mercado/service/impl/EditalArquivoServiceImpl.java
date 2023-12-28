package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.api.response.EditalArquivoResponse;
import br.com.projeto.mercado.models.EditalArquivo;
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
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class EditalArquivoServiceImpl implements EditalArquivoService {

    private final EditalRepository editalRepository;

    private final EditalArquivoRepository editalArquivoRepository;

    private final ArquivoStorageService arquivoStorageService;

    private final EditalArquivoMapper editalArquivoMapper;

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

}
