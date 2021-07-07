package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.macedo.sistemas.domain.enums.TipoMovimentacaoEnum;

@Entity
@Table(name = "movimentacao")
public class Movimentacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idMovimentacao;
	
	private Date dataMovimentacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoMovimentacaoEnum tipoMovimentacaoEnum;
	
	private Double dosagem;
	
	@ManyToOne
	private Medicamento medicamento;
	
	@ManyToOne
	private Lote lote;
	
	public Movimentacao() {
		// TODO Auto-generated constructor stub
	}

	public Movimentacao(Date dataMovimentacao, TipoMovimentacaoEnum tipoMovimentacaoEnum, Double dosagem,
			Medicamento medicamento, Lote lote) {
		super();
		this.dataMovimentacao = dataMovimentacao;
		this.tipoMovimentacaoEnum = tipoMovimentacaoEnum;
		this.dosagem = dosagem;
		this.medicamento = medicamento;
		this.lote = lote;
	}

	public Long getIdMovimentacao() {
		return idMovimentacao;
	}

	public void setIdMovimentacao(Long idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public TipoMovimentacaoEnum getTipoMovimentacaoEnum() {
		return tipoMovimentacaoEnum;
	}

	public void setTipoMovimentacaoEnum(TipoMovimentacaoEnum tipoMovimentacaoEnum) {
		this.tipoMovimentacaoEnum = tipoMovimentacaoEnum;
	}

	public Double getDosagem() {
		return dosagem;
	}

	public void setDosagem(Double dosagem) {
		this.dosagem = dosagem;
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
