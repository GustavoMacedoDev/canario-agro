package br.com.macedo.sistemas.domain.dto;

import java.util.Date;

public class IndiceNewDto {

	private Double valor;
	
	private Date dataReferencia;
	
	private String indexador; 
	
	public IndiceNewDto() {
		// TODO Auto-generated constructor stub
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataReferencia() {
		return dataReferencia;
	}

	public void setDataReferencia(Date dataReferencia) {
		this.dataReferencia = dataReferencia;
	}

	public String getIndexador() {
		return indexador;
	}

	public void setIndexador(String indexador) {
		this.indexador = indexador;
	}
	
	
}
