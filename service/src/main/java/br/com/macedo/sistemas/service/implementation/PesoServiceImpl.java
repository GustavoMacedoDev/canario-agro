package br.com.macedo.sistemas.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Peso;
import br.com.macedo.sistemas.domain.repository.PesoRepository;
import br.com.macedo.sistemas.domain.service.AnimalService;
import br.com.macedo.sistemas.domain.service.PesoService;

@Service
public class PesoServiceImpl implements PesoService {

	@Autowired
	private PesoRepository pesoRepository;
	
	@Autowired
	private AnimalService animalService;
	
	@Override
	public Peso insert(Peso peso) {
		
		peso.setIdPeso(null);
		pesoRepository.save(peso);
		
		animalService.atualizaPesoAtual(peso);
		
		return peso;
	}

	@Override
	public List<Peso> findByIdAnimal(Long id) {
		
		return pesoRepository.findAllByAnimalId(id);
	}

	@Override
	public Peso validaCadastra(Peso peso) {
		
		peso = pesoRepository.validaCadastro(peso.getIdPeso(), peso.getDataRegistro());
		
		System.out.println(peso.toString());
		
		return null;
	}

	@Override
	public Double buscaPesoAtualByIdAnimal(Long id) {
		
		return pesoRepository.buscaPesoAtualByIdAnimal(id);
	}

	

	
	
}
