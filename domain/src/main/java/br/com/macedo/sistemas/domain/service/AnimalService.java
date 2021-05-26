package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Animal;
import br.com.macedo.sistemas.domain.dto.AnimalNewDto;

public interface AnimalService {
	
	List<Animal> buscaAnimais();
	
	Animal fromDto(AnimalNewDto animalNewDto);
	
	Animal insert(Animal animal);
	
	Animal findById(Long id);
	

}
