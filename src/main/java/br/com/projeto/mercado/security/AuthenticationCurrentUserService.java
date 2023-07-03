package br.com.projeto.mercado.security;

import br.com.projeto.mercado.api.filter.EditalFiltro;
import br.com.projeto.mercado.api.filter.ProdutoFiltro;
import br.com.projeto.mercado.models.enums.TipoGrupo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationCurrentUserService {

    public UserDetailsImpl getCurrentUser(){
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public void verifyProductIsRoleAdmin(ProdutoFiltro filter) {
        this.getAuthentication().getAuthorities().forEach(
                grantedAuthority -> {
                    if (!(grantedAuthority.getAuthority().equals(TipoGrupo.ROLE_ADMIN.name()))){
                        filter.setUserId(this.getCurrentUser().getUserId());
                    }
                } );
    }

    public void verifyNoticeIsRoleAdmin(EditalFiltro filter) {
        this.getAuthentication().getAuthorities().forEach(
                grantedAuthority -> {
                    if (grantedAuthority.getAuthority().equals(TipoGrupo.ROLE_BUYER.name())){
                        filter.setUserId(this.getCurrentUser().getUserId());
                    }
                } );
    }


}
