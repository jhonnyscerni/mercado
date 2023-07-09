package br.com.projeto.mercado.service.email;

import br.com.projeto.mercado.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EnvioEmailService envioEmailService;

    public void sendNewPasswordEmail(Usuario usuario) {
        EnvioEmailService.Mensagem mensagem = EnvioEmailService.Mensagem.builder()
                .assunto(usuario.getEmpresa().getNomeFantasia() + " - Recuperação de senha")
                .corpo("modelo-recuperar-senha.html")
                .variavel("usuario", usuario)
                .variavel("novaSenha", usuario.getPassword())
                .destinatario(usuario.getEmail())
                .build();
        envioEmailService.enviar(mensagem, SmtpTipoEnvioEmail.SIMPLES);
    }
}
