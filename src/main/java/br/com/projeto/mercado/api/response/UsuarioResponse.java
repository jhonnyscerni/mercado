package br.com.projeto.mercado.api.response;

import br.com.projeto.mercado.models.Endereco;
import br.com.projeto.mercado.models.enums.StatusUsuario;
import br.com.projeto.mercado.models.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Set;

@Data
public class UsuarioResponse {

    private String nome;

    private String cpf;

    private Long id;

    private String username;

    private String email;

    private String telefone;

    @JsonIgnore
    private String password;

    private TipoUsuario tipoUsuario;

    private StatusUsuario statusUsuario;

    private EmpresaResponse empresa;

    private Set<GrupoResponse> grupos;

}
