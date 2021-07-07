package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Peso;

public interface PesoService {
	
	Peso insert(Peso peso);
	
	Peso validaCadastra(Peso peso);

	List<Peso> findByIdAnimal(Long id);
	
	Double buscaPesoAtualByIdAnimal(Long id);


}
