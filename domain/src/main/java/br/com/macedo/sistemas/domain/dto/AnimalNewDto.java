package br.com.macedo.sistemas.domain.dto;

import java.util.Date;

import br.com.macedo.sistemas.domain.aggregate.Categoria;
import br.com.macedo.sistemas.domain.aggregate.Pessoa;
import br.com.macedo.sistemas.domain.aggregate.Raca;
import br.com.macedo.sistemas.domain.enums.SexoEnum;

public class AnimalNewDto {
	
	private String nome;
	private Date dataEntrada;
	private Double pesoEntrada;
	private String identificacao;
	private SexoEnum sexo;
	private Raca raca;
	private Categoria categoria;
	private Pessoa fornecedor;
	private Pessoa produtor;
	
	
	public AnimalNewDto() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Double getPesoEntrada() {
		return pesoEntrada;
	}

	public void setPesoEntrada(Double pesoEntrada) {
		this.pesoEntrada = pesoEntrada;
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
