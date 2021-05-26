package br.com.macedo.sistemas.domain.dto;

import java.util.Date;

public class LoteNewDto {
	
	private String lote;
	private Date dataFabricacao;
	private Date dataValidade;
	
	public LoteNewDto() {
		// TODO Auto-generated constructor stub
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

}
