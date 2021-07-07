package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Animal;
import br.com.macedo.sistemas.domain.aggregate.Peso;
import br.com.macedo.sistemas.domain.aggregate.Venda;
import br.com.macedo.sistemas.domain.dto.AnimalNewDto;

public interface AnimalService {
	
	List<Animal> buscaTodosAnimais();
	
	List<Animal> buscaAnimaisEmEstoque();
	
	Animal fromDto(AnimalNewDto animalNewDto);
	
	Animal insert(Animal animal);
	
	Animal findById(Long id);
	
	void atualizaPesoAtual(Peso peso);
	
	void atualizaEstoqueAnimais(Venda venda);
	

}
