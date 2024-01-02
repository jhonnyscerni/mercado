package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.response.EditalArquivoResponse;
import br.com.projeto.mercado.models.EditalArquivo;

import java.io.InputStream;
import java.util.List;

public interface EditalArquivoService {

    List<EditalArquivoResponse> findAll();

    EditalArquivo buscarOuFalhar(Long id);

    EditalArquivoResponse salvar(EditalArquivo arquivo, InputStream dadosArquivo);

    EditalArquivoResponse findEditalArquivoById(Long id);

    void excluir(Long editalId);
}
