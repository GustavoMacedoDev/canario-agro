package br.com.macedo.sistemas.domain.dto;

import java.util.Date;

import br.com.macedo.sistemas.domain.aggregate.Lote;
import br.com.macedo.sistemas.domain.aggregate.Medicamento;
import br.com.macedo.sistemas.domain.enums.TipoMovimentacaoEnum;

public class MovimentacaoNewDto {

	private Date dataMovimentacao;
	private TipoMovimentacaoEnum tipo;
	private Double dosagem;
	private Medicamento medicamento;
	private Lote lote;
	
	public MovimentacaoNewDto() {
		// TODO Auto-generated constructor stub
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public TipoMovimentacaoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacaoEnum tipo) {
		this.tipo = tipo;
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
