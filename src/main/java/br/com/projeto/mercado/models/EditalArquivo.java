package br.com.projeto.mercado.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "edital_arquivo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_edital_arquivo", sequenceName = "seq_edital_arquivo", initialValue = 1, allocationSize = 1)
public class EditalArquivo extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_edital_arquivo")
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // ela é mapeada com o ID que é o codigo do edital
    private Edital edital;

    private String nomeArquivo;
    private String descricao;
    private String contentType;
    private Long tamanho;

}