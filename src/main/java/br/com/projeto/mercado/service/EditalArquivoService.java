package br.com.projeto.mercado.service;

import br.com.projeto.mercado.api.response.EditalArquivoResponse;
import br.com.projeto.mercado.models.EditalArquivo;

import java.io.InputStream;

public interface EditalArquivoService {

    EditalArquivoResponse salvar(EditalArquivo arquivo, InputStream dadosArquivo);
}
