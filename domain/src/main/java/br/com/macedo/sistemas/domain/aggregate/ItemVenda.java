package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_venda")
public class ItemVenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemVendaPk id = new ItemVendaPk();
	
	@Column
	private  Double valorItem;
	
	
	public ItemVenda() {
		// TODO Auto-generated constructor stub
	}

	public ItemVenda(Venda venda, Animal animal, Double valorItem) {
		super();
		id.setVenda(venda);
		id.setAnimal(animal);
		this.valorItem = valorItem;
	}
	
	
	@JsonIgnore
	public Venda getVenda() {
		return id.getVenda();
	}
	
	public void setVenda(Venda venda) {
		id.setVenda(venda);
	}
	
	public Animal getAnimal() {
		return id.getAnimal();
	}
	
	public void setAnimal(Animal animal) {
		id.setAnimal(animal);
	}
	
	public ItemVendaPk getId() {
		return id;
	}
	
	public void setId(ItemVendaPk id) {
		this.id = id;
	}

	public Double getValorItem() {
		return valorItem;
	}

	public void setValorItem(Double valorItem) {
		this.valorItem = valorItem;
	}

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", valorItem=" + valorItem + "]";
	}	
	
	
}
