package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lote")
public class Lote implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLote;

	@Column(unique = true)
	private String lote;
	
	private Date dataFabricacao;
	
	private Date dataValidade;
	
	private Double saldo = 0.0;
	
	@ManyToOne
	private Medicamento medicamento;
	
	public Lote() {
		// TODO Auto-generated constructor stub
	}

	public Lote(String lote, Date dataFabricacao, Date dataValidade, Double saldo, Medicamento medicamento) {
		super();
		this.lote = lote;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.saldo = saldo;
		this.medicamento = medicamento;
	}

	public Long getIdLote() {
		return idLote;
	}

	public void setIdLote(Long idLote) {
		this.idLote = idLote;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}	

	
}
