package br.com.projeto.mercado.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "edital")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_edital", sequenceName = "seq_edital", allocationSize = 1, initialValue = 1)
public class Edital extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_edital")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "data_inicio")
    private OffsetDateTime dataInicio;

    @Column(name = "data_fim")
    private OffsetDateTime dataFim;

    @Column(name = "data_exibe")
    private OffsetDateTime dataExibicao;

    @Column(name = "tempo_maximo_entrega")
    private Long tempoMaximoEntrega;

    @ManyToOne(targetEntity = Empresa.class)
    @JoinColumn(name = "empresa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id_fk"))
    private Empresa empresa;

    @OneToMany(mappedBy = "edital", cascade = CascadeType.ALL)
    private Set<EditalItem> itens = new HashSet<>();

    @OneToMany(mappedBy = "edital", cascade = CascadeType.ALL)
    private Set<Regiao> regioes = new HashSet<>();

    @OneToMany(mappedBy = "edital", cascade = CascadeType.ALL)
    private Set<FormaPagamento> formasPagamento = new HashSet<>();

    @ManyToOne(targetEntity = Endereco.class)
    @JoinColumn(name = "endereco_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_id_fk"))
    private Endereco endereco;

    //TODO. criar parametro para definição de critério de vencedor
    //private CriterioVencedor criterioVencedor

    public void geradorNumeroEdital(){
        this.setNumero(Calendar.getInstance().getTime().getTime());
     }

}
