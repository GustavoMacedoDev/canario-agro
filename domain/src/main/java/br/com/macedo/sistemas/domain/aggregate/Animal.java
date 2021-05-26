package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.macedo.sistemas.domain.enums.SexoEnum;

@Entity
@Table(name = "animal")
public class Animal implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animal")
	private Long idAnimal;
	@Column
	private String nome;
	@Column
	private String identificacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", nullable = false)
	private SexoEnum sexo;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	@Column(name = "peso_nascimento")
	private Double pesoNascimento;
	
	@ManyToOne
	private Produtor produtor;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	private Raca raca;
	
	@ManyToOne
	private Categoria categoria;
	
	public Animal() {
		
	}

	public Animal(String nome, String identificacao, SexoEnum sexo, Date dataNascimento, Double pesoNascimento,
			Produtor produtor, Fornecedor fornecedor, Raca raca, Categoria categoria) {
		super();
		this.nome = nome;
		this.identificacao = identificacao;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.pesoNascimento = pesoNascimento;
		this.produtor = produtor;
		this.fornecedor = fornecedor;
		this.raca = raca;
		this.categoria = categoria;
	}

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getPesoNascimento() {
		return pesoNascimento;
	}

	public void setPesoNascimento(Double pesoNascimento) {
		this.pesoNascimento = pesoNascimento;
	}

	public Produtor getProdutor() {
		return produtor;
	}

	public void setProdutor(Produtor produtor) {
		this.produtor = produtor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	
}
