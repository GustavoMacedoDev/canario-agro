package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aplicacao")
public class Aplicacao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAplicacao;
	
	private Date dataAplicacao;
	@ManyToOne
	private Animal animal;
	@ManyToOne
	private Medicamento medicamento;
	@ManyToOne
	private Lote lote;
	
	public Aplicacao() {
		// TODO Auto-generated constructor stub
	}
	
	public Aplicacao(Date dataAplicacao, Animal animal, Medicamento medicamento, Lote lote) {
		super();
		this.dataAplicacao = dataAplicacao;
		this.animal = animal;
		this.medicamento = medicamento;
		this.lote = lote;
	}

	public Long getIdAplicacao() {
		return idAplicacao;
	}

	public void setIdAplicacao(Long idAplicacao) {
		this.idAplicacao = idAplicacao;
	}

	public Date getDataAplicacao() {
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		this.dataAplicacao = dataAplicacao;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
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
