package br.com.projeto.mercado.service.storage;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.projeto.mercado.core.storage.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;

//@Service
public class LocalArquivoStorageService implements ArquivoStorageService {

//    @Value("${siberius.storage.local.diretorio-fotos}")
//    private Path diretorioFotos;

    @Autowired
    private StorageProperties storageProperties;

    @Override
    public void armazenar(NovoArquivo novoArquivo) {
        try {
            Path arquivoPath = getArquivoPath(novoArquivo.getNomeArquivo());

            FileCopyUtils.copy(novoArquivo.getInputStream(),
                Files.newOutputStream(arquivoPath));
        } catch (Exception e) {
            throw new StorageException("Não foi possível armazenar arquivo.", e);
        }
    }

    @Override
    public void remover(String nomeArquivo) {
        try {
            Path arquivoPath = getArquivoPath(nomeArquivo);

            Files.deleteIfExists(arquivoPath);
        } catch (Exception e) {
            throw new StorageException("Não foi possível excluir arquivo.", e);
        }

    }

    private Path getArquivoPath(String nomeArquivo) {
//        return diretorioFotos.resolve(Paths.get(nomeArquivo));
        return storageProperties.getLocal().getDiretorio().resolve(Paths.get(nomeArquivo));
    }

    @Override
    public ArquivoRecuperada recuperar(String nomeArquivo) {
        try {
            Path arquivoPath = getArquivoPath(nomeArquivo);

            ArquivoRecuperada arquivoRecuperada = ArquivoRecuperada.builder()
                .inputStream(Files.newInputStream(arquivoPath))
                .build();

            return arquivoRecuperada;
        } catch (Exception e) {
            throw new StorageException("Não foi possível recuperar arquivo.", e);
        }
    }

}
