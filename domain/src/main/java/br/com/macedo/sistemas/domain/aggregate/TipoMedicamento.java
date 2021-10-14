package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_medicamento")
public class TipoMedicamento implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoMedicamento;
	
	@Column(unique = true)
	private String tipo;
	
	public TipoMedicamento() {
		// TODO Auto-generated constructor stub
	}

	public TipoMedicamento(String tipo) {
		super();
		this.tipo = tipo;
	}

	public Long getIdTipoMedicamento() {
		return idTipoMedicamento;
	}

	public void setIdTipoMedicamento(Long idTipoMedicamento) {
		this.idTipoMedicamento = idTipoMedicamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
