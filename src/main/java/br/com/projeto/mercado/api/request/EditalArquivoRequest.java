package br.com.projeto.mercado.api.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.projeto.mercado.core.validation.FileContentType;
import br.com.projeto.mercado.core.validation.FileSize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class EditalArquivoRequest {

    //@NotNull
    //@FileSize(max = "500KB")
    //@FileContentType(allowed = { MediaType.APPLICATION_PDF_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    private MultipartFile arquivo;

    private String descricao;

}
