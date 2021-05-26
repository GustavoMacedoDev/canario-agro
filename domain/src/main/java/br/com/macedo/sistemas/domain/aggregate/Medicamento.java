package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicamento")
public class Medicamento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedicamento;
	
	private String nome;
	
	@ManyToOne
	private TipoMedicamento tipo;
	
	public Medicamento() {
		// TODO Auto-generated constructor stub
	}

	public Medicamento(String nome, TipoMedicamento tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
	}


	public Long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
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
