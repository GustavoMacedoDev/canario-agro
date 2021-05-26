package br.com.macedo.sistemas.domain.aggregate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtor")
public class Produtor implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdutor;
	
	private String razaoSocial;
	
	private String nome;
	
	public Produtor() {
		// TODO Auto-generated constructor stub
	}

	public Produtor(String razaoSocial, String nome) {
		super();
		this.razaoSocial = razaoSocial;
		this.nome = nome;
	}

	public Long getIdProdutor() {
		return idProdutor;
	}

	public void setIdProdutor(Long idProdutor) {
		this.idProdutor = idProdutor;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
