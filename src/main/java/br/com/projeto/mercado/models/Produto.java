package br.com.projeto.mercado.models;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "Código externo do produto")
    private String codigoExterno;

    @Size(min = 10, message = "Nome do produto deve ter mais de 10 letras")
    @NotNull(message = "Nome do produto deve ser informado")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "Descrição do produto deve ser informada")
    @Column(columnDefinition = "text", length = 2000, nullable = false)
    private String descricao;

    @NotNull(message = "A empresa responsável deve ser informada")
    @ManyToOne(targetEntity = Empresa.class)
    @JoinColumn(name = "empresa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id_fk"))
    private Empresa empresa;

    @NotNull(message = "A Categoria do Produto deve ser informada")
    @ManyToOne(targetEntity = CategoriaProduto.class)
    @JoinColumn(name = "categoria_produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "categoria_produto_id_fk"))
    private CategoriaProduto categoriaProduto = new CategoriaProduto();

    @NotNull(message = "A Marca do Produto deve ser informada")
    @ManyToOne(targetEntity = MarcaProduto.class)
    @JoinColumn(name = "marca_produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "marca_produto_id_fk"))
    private MarcaProduto marcaProduto = new MarcaProduto();

    @OneToMany(mappedBy = "produto", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ImagemProduto> imagens = new ArrayList<ImagemProduto>();

    //////////////////////////////////////////// FIM ////////////////////////////////////////////


    @NotNull(message = "O tipo da unidade deve ser informado")
    @Column(nullable = false)
    private String tipoUnidade;

    /** Nota item nota produto - ASSOCIAR **/

    @NotNull(message = "Peso deve ser informado")
    @Column(nullable = false)
    private Double peso; /* 1000.55 G */

    @NotNull(message = "Largura deve ser informado")
    @Column(nullable = false)
    private Double largura;

    @NotNull(message = "Altura deve ser informado")
    @Column(nullable = false)
    private Double altura;

    @NotNull(message = "Profundidade")
    @Column(nullable = false)
    private Double profundidade;

    @NotNull(message = "Valor de venda deve ser informado")
    @Column(nullable = false)
    private BigDecimal valorVenda = BigDecimal.ZERO;

    @Column(nullable = false)
    private Integer qtdEstoque = 0;

    private Integer qtdeAlertaEstoque = 0;

    private String linkYoutube;

    private Boolean alertaQtdeEstoque = Boolean.FALSE;

    private Integer qtdeClique = 0;




}
