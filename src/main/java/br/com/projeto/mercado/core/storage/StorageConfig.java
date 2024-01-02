package br.com.projeto.mercado.core.storage;

import br.com.projeto.mercado.service.storage.ArquivoStorageService;
import br.com.projeto.mercado.service.storage.LocalArquivoStorageService;
import br.com.projeto.mercado.service.storage.S3ArquivoStorageService;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.projeto.mercado.core.storage.StorageProperties.TipoStorage;

@Configuration
public class StorageConfig {

    @Autowired
    private StorageProperties storageProperties;

    @Bean
    @ConditionalOnProperty(name = "projeto.storage.tipo", havingValue = "s3")
    public AmazonS3 amazonS3() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(
            storageProperties.getS3().getIdChaveAcesso(),
            storageProperties.getS3().getChaveAcessoSecreta());

        return AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(storageProperties.getS3().getRegiao())
            .build();
    }

    @Bean
    public ArquivoStorageService arquivoStorageService() {
        if (TipoStorage.S3.equals(storageProperties.getTipo())) {
            return new S3ArquivoStorageService();
        } else {
            return new LocalArquivoStorageService();
        }
    }

}