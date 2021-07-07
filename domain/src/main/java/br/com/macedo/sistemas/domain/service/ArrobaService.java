package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Arroba;

public interface ArrobaService {
	
	List<Arroba> buscaArrobas();
	
	Arroba insert(Arroba arroba);
	
	Arroba findById(Long id);
	
	

}
