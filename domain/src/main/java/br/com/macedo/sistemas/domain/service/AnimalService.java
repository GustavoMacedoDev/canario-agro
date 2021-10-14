package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Animal;
import br.com.macedo.sistemas.domain.aggregate.Peso;
import br.com.macedo.sistemas.domain.aggregate.Venda;

public interface AnimalService {
	
	List<Animal> buscaAnimaisEmEstoque();
	
	List<Animal> buscaAnimaisDisponiveis(String status);
	
	List<Animal> buscaAnimaisPorSexo(String sexo);
	
	List<Animal> buscaAnimaisVendidos();
	
	List<Animal> buscaAnimaisBloqueados();
	
	Animal insert(Animal animal);
	
	Animal findById(Long id);
	
	void atualizaPesoAtual(Peso peso);
	
	void atualizaEstoqueAnimais(Venda venda);
	

}
