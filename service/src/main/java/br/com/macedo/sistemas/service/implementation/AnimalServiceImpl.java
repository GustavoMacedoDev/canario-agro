package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Animal;
import br.com.macedo.sistemas.domain.aggregate.ItemVenda;
import br.com.macedo.sistemas.domain.aggregate.Peso;
import br.com.macedo.sistemas.domain.aggregate.Venda;
import br.com.macedo.sistemas.domain.enums.StatusEstoqueEnum;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.AnimalRepository;
import br.com.macedo.sistemas.domain.service.AnimalService;
import br.com.macedo.sistemas.domain.service.PesoService;

@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private PesoService pesoService;
	
	@Override
	public Animal insert(Animal animal) {
		animal.setId(null);
		animal.setPesoAtual(animal.getPesoEntrada());
		
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
	public void atualizaEstoqueAnimais(Venda venda) {
		for (ItemVenda item : venda.getItens()) {
			Animal animal = item.getAnimal();
			animal.setStatus(StatusEstoqueEnum.VENDIDO);
			animalRepository.save(animal);
		}
	}

	@Override
	public List<Animal> buscaAnimaisDisponiveis(String status) {
		return animalRepository.buscaAnimaisDisponiveis(status);
	}

	@Override
	public List<Animal> buscaAnimaisVendidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Animal> buscaAnimaisBloqueados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Animal> buscaAnimaisEmEstoque() {
		return animalRepository.buscaAnimaisEmEstoque();
	}

	@Override
	public List<Animal> buscaAnimaisPorSexo(String sexo) {
		return animalRepository.buscaAnimaisPorSexo(sexo);
	}
}







