package br.com.macedo.sistemas.domain.dto;

import java.util.Date;

import br.com.macedo.sistemas.domain.aggregate.Categoria;
import br.com.macedo.sistemas.domain.aggregate.Fornecedor;
import br.com.macedo.sistemas.domain.aggregate.Produtor;
import br.com.macedo.sistemas.domain.aggregate.Raca;
import br.com.macedo.sistemas.domain.enums.SexoEnum;

public class AnimalNewDto {
	
	private String nome;
	private Date dataNascimento;
	private Double pesoNascimento;
	private String identificacao;
	private SexoEnum sexo;
	private Produtor produtor;
	private Fornecedor fornecedor;
	private Raca raca;
	private Categoria categoria;
	
	public AnimalNewDto() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
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
	
}
