package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Animal;
import br.com.macedo.sistemas.domain.aggregate.ItemVenda;
import br.com.macedo.sistemas.domain.aggregate.Peso;
import br.com.macedo.sistemas.domain.aggregate.Venda;
import br.com.macedo.sistemas.domain.dto.AnimalNewDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.AnimalRepository;
import br.com.macedo.sistemas.domain.repository.ItemVendaRepository;
import br.com.macedo.sistemas.domain.service.AnimalService;
import br.com.macedo.sistemas.domain.service.PesoService;

@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	@Autowired
	private PesoService pesoService;
	
	@Override
	public Animal insert(Animal animal) {
		animal.setId(null);
		
		animalRepository.save(animal);
		
		lancaPesoEntrada(animal);
		
		return animal;
		
	}
	
	private void lancaPesoEntrada(Animal animal) {
		
		Peso peso = new Peso();
		peso.setIdPeso(null);
		peso.setDataRegistro(animal.getDataEntrada());
		peso.setPeso(animal.getPesoEntrada());
		peso.setAnimal(animal);
		
		pesoService.insert(peso);
		
	}
	
	@Override
	public Animal fromDto(AnimalNewDto animalNewDto) {
		return null;
	}

	@Override
	public Animal findById(Long id) {
		Optional<Animal> animal = animalRepository.findById(id);
		
		return animal.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Animal.class.getName()));
	}

	@Override
	public void atualizaPesoAtual(Peso peso) {
		Animal animal = new Animal();
		
		animal = animalRepository.getOne(peso.getAnimal().getId());
		
		animal.setPesoAtual(peso.getPeso());
		
		animalRepository.save(animal);
		
	}

	@Override
	public List<Animal> buscaTodosAnimais() {
		
		return animalRepository.findAll();
	}

	@Override
	public List<Animal> buscaAnimaisEmEstoque() {
		
		return animalRepository.buscaAnimaisEmEstoque();
	}
	
	@Override
	public void atualizaEstoqueAnimais(Venda venda) {
		
		List<ItemVenda> itens = itemVendaRepository.findAllByIdVendaIdVenda(venda.getIdVenda());
		
		for (ItemVenda itemVenda : itens) {
			Animal animal = animalRepository.getOne(itemVenda.getAnimal().getId());
			animal.setEmEstoque(false);
			animalRepository.save(animal);
		}
		
		
	}
}







