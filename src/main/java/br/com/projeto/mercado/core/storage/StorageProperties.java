package br.com.projeto.mercado.core.storage;


import com.amazonaws.regions.Regions;
import java.nio.file.Path;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("projeto.storage")
public class StorageProperties {

    private Local local = new Local();
    private S3 s3 = new S3();
    private TipoStorage tipo = TipoStorage.LOCAL;

    public enum TipoStorage {
        LOCAL, S3
    }

    @Getter
    @Setter
    public class Local {

        private Path diretorio;

    }

    @Getter
    @Setter
    public class S3 {

        private String idChaveAcesso;
        private String chaveAcessoSecreta;
        private String bucket;
        private Regions regiao;
        private String diretorioFotos;

    }

}