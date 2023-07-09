package br.com.projeto.mercado.api.request;

import br.com.projeto.mercado.models.Empresa;
import br.com.projeto.mercado.models.Grupo;
import br.com.projeto.mercado.models.enums.StatusUsuario;
import br.com.projeto.mercado.models.enums.TipoUsuario;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UsuarioRequest {

    private String username;

    private String email;

    private String telefone;

    private String password;

    private TipoUsuario tipoUsuario;

    private StatusUsuario statusUsuario;

    private Empresa empresa;

    Set<Grupo> grupos = new HashSet<>();

}
