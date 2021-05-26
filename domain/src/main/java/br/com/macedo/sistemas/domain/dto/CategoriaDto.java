package br.com.macedo.sistemas.domain.dto;

import javax.validation.constraints.NotNull;

public class CategoriaDto {
	
	@NotNull
	private String nome;
	
	public CategoriaDto() {
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
