package br.com.projeto.mercado.api.response;

import br.com.projeto.mercado.models.Endereco;
import br.com.projeto.mercado.models.enums.StatusUsuario;
import br.com.projeto.mercado.models.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioResponse {

    private Long id;

    private String username;

    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private List<Endereco> enderecos = new ArrayList<Endereco>();

    private String inscEstadual;

    private String inscMunicipal;

    private String categoria;

    private String email;

    private String telefone;

    @JsonIgnore
    private String password;

    private TipoUsuario tipoUsuario;

    private StatusUsuario statusUsuario;

}
