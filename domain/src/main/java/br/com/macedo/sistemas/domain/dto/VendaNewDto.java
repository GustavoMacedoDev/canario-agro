package br.com.macedo.sistemas.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import br.com.macedo.sistemas.domain.aggregate.Animal;
import br.com.macedo.sistemas.domain.aggregate.ItemVenda;
import br.com.macedo.sistemas.domain.aggregate.Pessoa;

public class VendaNewDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Pessoa cliente;
	private Date dataVenda;
	private Animal animal;
	private Double valorItem;
	private Set<ItemVenda> itens;
	private Double totalVenda;
	
	public VendaNewDto() {
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Double getValorItem() {
		return valorItem;
	}
	public void setValorItem(Double valorItem) {
		this.valorItem = valorItem;
	}
	public Set<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(Set<ItemVenda> itens) {
		this.itens = itens;
	}
	public Double getTotalVenda() {
		return totalVenda;
	}
	public void setTotalVenda(Double totalVenda) {
		this.totalVenda = totalVenda;
	}
	
}
