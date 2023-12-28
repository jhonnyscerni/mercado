package br.com.projeto.mercado.service.storage;

import java.io.InputStream;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

public interface ArquivoStorageService {

    ArquivoRecuperada recuperar(String nomeArquivo);

    void armazenar(NovoArquivo novoArquivo);

    void remover(String nomeArquivo);

    default void substituir(String nomeArquivoAntigo, NovoArquivo novoArquivo) {
        this.armazenar(novoArquivo);

        if (nomeArquivoAntigo != null) {
            this.remover(nomeArquivoAntigo);
        }
    }

    default String gerarNomeArquivo(String nomeOriginal) {
        return UUID.randomUUID().toString() + "_" + nomeOriginal;
    }

    @Builder
    @Getter
    class NovoArquivo {

        private String nomeArquivo;
        private String contentType;
        private InputStream inputStream;

    }

    @Builder
    @Getter
    class ArquivoRecuperada {

        private InputStream inputStream;
        private String url;

        public boolean temUrl() {
            return url != null;
        }

        public boolean temInputStream() {
            return inputStream != null;
        }

    }

}
