package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Animal;
import br.com.macedo.sistemas.domain.dto.AnimalNewDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.AnimalRepository;
import br.com.macedo.sistemas.domain.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public List<Animal> buscaAnimais() {
		return this.animalRepository.findAll();
	}

	@Override
	public Animal insert(Animal animal) {
		animal.setIdAnimal(null);
		
		return animalRepository.save(animal);
		
	}
	@Override
	public Animal fromDto(AnimalNewDto animalNewDto) {
		return new Animal(animalNewDto.getNome(), animalNewDto.getIdentificacao(), 
				animalNewDto.getSexo(), animalNewDto.getDataNascimento(), 
				animalNewDto.getPesoNascimento(), animalNewDto.getProdutor(), 
				animalNewDto.getFornecedor(), animalNewDto.getRaca(), animalNewDto.getCategoria());
	}

	@Override
	public Animal findById(Long id) {
		Optional<Animal> animal = animalRepository.findById(id);
		
		return animal.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Animal.class.getName()));
	}
}
