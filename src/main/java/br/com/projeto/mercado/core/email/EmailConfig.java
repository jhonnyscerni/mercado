package br.com.projeto.mercado.core.email;

import br.com.projeto.mercado.service.email.EnvioEmailService;
import br.com.projeto.mercado.service.email.FakeEnvioEmailService;
import br.com.projeto.mercado.service.email.SandboxEnvioEmailService;
import br.com.projeto.mercado.service.email.SmtpEnvioEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmailConfig {

    @Autowired
    private EmailProperties emailProperties;

    @Bean
    public EnvioEmailService envioEmailService() {
        // Acho melhor usar switch aqui do que if/else if
        switch (emailProperties.getImpl()) {
            case FAKE:
                return new FakeEnvioEmailService();
            case SMTP:
                return new SmtpEnvioEmailService();
            case SANDBOX:
                return new SandboxEnvioEmailService();
            default:
                return null;
        }
    }

}