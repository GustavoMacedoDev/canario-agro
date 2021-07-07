package br.com.macedo.sistemas.domain.dto;

import java.util.Date;

public class AnimalDto {
	
	private String nome;
	private String identificacao;
	private Date dataNascimento;
	private Double pesoNascimento;
	
	public AnimalDto() {
		// TODO Auto-generated constructor stub
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

}
