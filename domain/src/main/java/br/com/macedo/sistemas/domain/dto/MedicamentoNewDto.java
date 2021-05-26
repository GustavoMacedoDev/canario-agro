package br.com.macedo.sistemas.domain.dto;

import br.com.macedo.sistemas.domain.aggregate.TipoMedicamento;

public class MedicamentoNewDto {
	
	private String nome;
	private TipoMedicamento tipo;
	
	public MedicamentoNewDto() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoMedicamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}	
	
}