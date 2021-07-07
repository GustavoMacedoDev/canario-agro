package br.com.macedo.sistemas.domain.dto;

import java.util.Date;

import br.com.macedo.sistemas.domain.aggregate.Animal;
import br.com.macedo.sistemas.domain.aggregate.Lote;
import br.com.macedo.sistemas.domain.aggregate.Medicamento;

public class AplicacaoNewDto {
	
	private Date dataAplicacao;
	private Animal animal;
	private Medicamento medicamento;
	private Lote lote;
	
	public AplicacaoNewDto() {
		// TODO Auto-generated constructor stub
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

}
