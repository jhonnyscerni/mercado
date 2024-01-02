package br.com.projeto.mercado.service.storage;

import br.com.projeto.mercado.core.storage.StorageProperties;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class S3ArquivoStorageService implements ArquivoStorageService {

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private StorageProperties storageProperties;

    @Override
    public ArquivoRecuperada recuperar(String nomeArquivo) {
        String caminhoArquivo = getCaminhoArquivo(nomeArquivo);

        URL url = amazonS3.getUrl(storageProperties.getS3().getBucket(), caminhoArquivo);

        return ArquivoRecuperada.builder()
            .url(url.toString()).build();
    }

    @Override
    public void armazenar(NovoArquivo novoArquivo) {
        try {
            String caminhoArquivo = getCaminhoArquivo(novoArquivo.getNomeArquivo());

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(novoArquivo.getContentType());

            PutObjectRequest putObjectRequest = new PutObjectRequest(
                storageProperties.getS3().getBucket(),
                caminhoArquivo,
                novoArquivo.getInputStream(),
                objectMetadata
            )
                .withCannedAcl(CannedAccessControlList.PublicRead);

            amazonS3.putObject(putObjectRequest);
        } catch (Exception e) {
            throw new StorageException("Não foi possível enviar arquivo Amazon S3", e);
        }
    }

    private String getCaminhoArquivo(String nomeArquivo) {
        return String.format("%s/%s", storageProperties.getS3().getDiretorio(), nomeArquivo);
    }

    @Override
    public void remover(String nomeArquivo) {
        try {
            String caminhoArquivo = getCaminhoArquivo(nomeArquivo);

            DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(
                storageProperties.getS3().getBucket(), caminhoArquivo);

            amazonS3.deleteObject(deleteObjectRequest);
        } catch (Exception e) {
            throw new StorageException("Não foi possível excluir arquivo na Amazon S3.", e);
        }
    }

}
