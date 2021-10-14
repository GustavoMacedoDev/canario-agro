package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.macedo.sistemas.domain.enums.SexoEnum;
import br.com.macedo.sistemas.domain.enums.StatusEstoqueEnum;


@Entity
@Table(name = "animal")
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animal")
	private Long id;
	@Column
	private String nome;
	@Column(unique = true)
	private String identificacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", nullable = false)
	private SexoEnum sexo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private StatusEstoqueEnum status;
	
	@Column(name = "data_entrada")
	private Date dataEntrada;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(name = "peso_entrada")
	private Double pesoEntrada;
	
	@Column(name = "peso_atual")
	private Double pesoAtual;
	
	@ManyToOne
	private Raca raca;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Pessoa fornecedor;
	
	@ManyToOne
	private Pessoa produtor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mae", referencedColumnName = "id_animal", updatable = false, insertable = false)
	private Animal mae;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pai", referencedColumnName = "id_animal", updatable = false, insertable = false)
	private Animal pai;
	
	@JsonIgnore
	@OneToMany(mappedBy="id.animal")
	private Set<ItemVenda> itens = new HashSet<>();
	
	public Animal() {
		
	}

	@JsonIgnore
	public List<Venda> getVendas() {
		List<Venda> lista = new ArrayList<>();
		for (ItemVenda x : itens) {
			lista.add(x.getVenda());
		}
		return lista;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getPesoEntrada() {
		return pesoEntrada;
	}

	public void setPesoEntrada(Double pesoEntrada) {
		this.pesoEntrada = pesoEntrada;
	}
	
	public Double getPesoAtual() {
		return pesoAtual;
	}

	public void setPesoAtual(Double pesoAtual) {
		this.pesoAtual = pesoAtual;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public StatusEstoqueEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEstoqueEnum status) {
		this.status = status;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Pessoa getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Pessoa fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Pessoa getProdutor() {
		return produtor;
	}

	public void setProdutor(Pessoa produtor) {
		this.produtor = produtor;
	}

}
