package br.com.projeto.mercado.api.dto;

import br.com.projeto.mercado.api.response.EmpresaResponse;
import br.com.projeto.mercado.models.enums.StatusUsuario;
import br.com.projeto.mercado.models.enums.TipoUsuario;
import lombok.Data;

@Data
public class UserDto {

    private String username;

    private String email;

    private String telefone;

    private String password;

    private TipoUsuario tipoUsuario;

    private StatusUsuario statusUsuario;

    private EmpresaResponse empresa;

}
