package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.request.EditalArquivoRequest;
import br.com.projeto.mercado.api.response.EditalArquivoResponse;
import br.com.projeto.mercado.models.Edital;
import br.com.projeto.mercado.models.EditalArquivo;
import br.com.projeto.mercado.service.EditalService;
import br.com.projeto.mercado.service.impl.EditalArquivoServiceImpl;
import br.com.projeto.mercado.service.storage.ArquivoStorageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/editais/{editalId}/arquivo")
public class EditalArquivoController {

    private final ArquivoStorageService arquivoStorageService;

    private final EditalService editalService;

    private final EditalArquivoServiceImpl editalArquivoService;

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EditalArquivoResponse atualizarArquivo(@PathVariable Long editalId, @Valid EditalArquivoRequest editalArquivoRequest) throws IOException {
        Edital edital = editalService.buscarOuFalhar(editalId);

        MultipartFile arquivo = editalArquivoRequest.getArquivo();

        EditalArquivo foto = new EditalArquivo();
        foto.setEdital(edital);
        foto.setDescricao(editalArquivoRequest.getDescricao());
        foto.setContentType(arquivo.getContentType());
        foto.setTamanho(arquivo.getSize());
        foto.setNomeArquivo(arquivo.getOriginalFilename());

        return editalArquivoService.salvar(foto, arquivo.getInputStream());
    }

//    @DeleteMapping
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void excluir(@PathVariable Long produtoId) {
//
//        // a parte do storage ja ta implementado no service
//        editalArquivoService.excluir(produtoId);
//    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public EditalArquivoResponse buscar(@PathVariable Long editalId) {
//        EditalArquivo fotoProduto = editalArquivoService.buscarOuFalhar(editalId);
//
//        return null;
//    }

    // é para retornar a foto em si
//    @GetMapping
//    public ResponseEntity<?> servir(@PathVariable Long produtoId, @RequestHeader(name = "accept") String acceptHeader)
//            throws HttpMediaTypeNotAcceptableException {
//        try {
//            FotoProduto fotoProduto = catalogoFotoProduto.buscarOuFalhar(produtoId);
//
//            //verificar os tipos (formatos) que são aceitos
//            MediaType mediaTypeFoto = MediaType.parseMediaType(fotoProduto.getContentType());
//            List<MediaType> mediaTypesAceitas = MediaType.parseMediaTypes(acceptHeader);
//
//            verificarCompatibilidadeMediaType(mediaTypeFoto, mediaTypesAceitas);
//            // fim
//
//            FotoRecuperada fotoRecuperada = arquivoStorageService.recuperar(fotoProduto.getNomeArquivo());
//
//            if (fotoRecuperada.temUrl()) {
//                return ResponseEntity
//                        .status(HttpStatus.FOUND)
//                        .header(HttpHeaders.LOCATION, fotoRecuperada.getUrl())
//                        .build();
//            } else {
//                return ResponseEntity.ok()
//                        .contentType(mediaTypeFoto)
//                        .body(new InputStreamResource(fotoRecuperada.getInputStream()));
//            }
//        } catch (EntidadeNaoEncontradaException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    private void verificarCompatibilidadeMediaType(MediaType mediaTypeFoto,
//                                                   List<MediaType> mediaTypesAceitas) throws HttpMediaTypeNotAcceptableException {
//
//        boolean compativel = mediaTypesAceitas.stream()
//                .anyMatch(mediaTypeAceita -> mediaTypeAceita.isCompatibleWith(mediaTypeFoto));
//
//        if (!compativel) {
//            throw new HttpMediaTypeNotAcceptableException(mediaTypesAceitas);
//        }
//    }
}
