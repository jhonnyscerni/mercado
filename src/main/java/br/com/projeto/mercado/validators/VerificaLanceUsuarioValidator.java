package br.com.projeto.mercado.validators;


import br.com.projeto.mercado.models.exceptions.BusinessException;
import br.com.projeto.mercado.repositories.LeilaoRepository;
import br.com.projeto.mercado.security.AuthenticationCurrentUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VerificaLanceUsuarioValidator {

    private final LeilaoRepository leilaoRepository;
    private final AuthenticationCurrentUserService authenticationCurrentUserService;

    public void validate(Long editalId, Long empresaId){
         leilaoRepository.findIdUsuarioAndIdLeilao(editalId, empresaId).ifPresent(leilao -> {
             throw new BusinessException("Sua Empresa ja possui um lance nesse edital" + leilao.getEdital().getNumero());
         });


    }
}
