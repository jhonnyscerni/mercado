package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.request.EditalArquivoRequest;
import br.com.projeto.mercado.api.response.EditalArquivoResponse;
import br.com.projeto.mercado.models.Edital;
import br.com.projeto.mercado.models.EditalArquivo;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
import br.com.projeto.mercado.service.EditalService;
import br.com.projeto.mercado.service.impl.EditalArquivoServiceImpl;
import br.com.projeto.mercado.service.storage.ArquivoStorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long editalId) {
        editalArquivoService.excluir(editalId);
    }

    @GetMapping
    public ResponseEntity<EditalArquivoResponse> buscar(@PathVariable Long editalId) {
        return ResponseEntity.ok().body(editalArquivoService.findEditalArquivoById(editalId));
    }

    @GetMapping("/url")
    public ResponseEntity<?> servir(@PathVariable Long editalId, @RequestHeader(name = "accept") String acceptHeader)
            throws HttpMediaTypeNotAcceptableException {
        try {
            EditalArquivo editalArquivo = editalArquivoService.buscarOuFalhar(editalId);

            //verificar os tipos (formatos) que são aceitos
            MediaType mediaTypeFoto = MediaType.parseMediaType(editalArquivo.getContentType());
            List<MediaType> mediaTypesAceitas = MediaType.parseMediaTypes(acceptHeader);

            verificarCompatibilidadeMediaType(mediaTypeFoto, mediaTypesAceitas);
            // fim

            ArquivoStorageService.ArquivoRecuperada fotoRecuperada = arquivoStorageService.recuperar(editalArquivo.getNomeArquivo());

            if (fotoRecuperada.temUrl()) {
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .header(HttpHeaders.LOCATION, fotoRecuperada.getUrl())
                        .build();
            } else {
                return ResponseEntity.ok()
                        .contentType(mediaTypeFoto)
                        .body(new InputStreamResource(fotoRecuperada.getInputStream()));
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private void verificarCompatibilidadeMediaType(MediaType mediaTypeFoto,
                                                   List<MediaType> mediaTypesAceitas) throws HttpMediaTypeNotAcceptableException {

        boolean compativel = mediaTypesAceitas.stream()
                .anyMatch(mediaTypeAceita -> mediaTypeAceita.isCompatibleWith(mediaTypeFoto));

        if (!compativel) {
            throw new HttpMediaTypeNotAcceptableException(mediaTypesAceitas);
        }
    }
}
