package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenda;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataVenda;
	
	@ManyToOne
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "id.venda")
	private Set<ItemVenda> itens = new HashSet<>();
	
	@Column(name = "total_venda")
	private Double totalVenda;
	
	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(Long idVenda, Date dataVenda, Pessoa pessoa, Double totalVenda) {
		super();
		this.idVenda = idVenda;
		this.dataVenda = dataVenda;
		this.pessoa = pessoa;
		this.totalVenda = totalVenda;
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVenda == null) ? 0 : idVenda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (idVenda == null) {
			if (other.idVenda != null)
				return false;
		} else if (!idVenda.equals(other.idVenda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [idVenda=" + idVenda + ", dataVenda=" + dataVenda + ", pessoa=" + pessoa + ", itens=" + itens
				+ ", totalVenda=" + totalVenda + "]";
	}	
	
}




