package br.com.projeto.mercado.models;

import br.com.projeto.mercado.models.enums.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)
public class Endereco extends Base implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(nullable = false)
	private String ruaLogra;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String numero;
	
	
	private String complemento;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = true)
	private String estado;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;

}
