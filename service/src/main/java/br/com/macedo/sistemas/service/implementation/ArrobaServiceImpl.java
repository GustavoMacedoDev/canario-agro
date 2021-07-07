package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Arroba;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.ArrobaRepository;
import br.com.macedo.sistemas.domain.service.ArrobaService;

@Service
public class ArrobaServiceImpl implements ArrobaService {
	
	@Autowired
	private ArrobaRepository arrobaRepository;

	@Override
	public List<Arroba> buscaArrobas() {
		return arrobaRepository.findAll();
	}

	@Override
	public Arroba insert(Arroba arroba) {
		arroba.setId(null);
		return arrobaRepository.save(arroba);
	}

	@Override
	public Arroba findById(Long id) {
		Optional<Arroba> arroba = arrobaRepository.findById(id);
		
		return arroba.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Arroba.class.getName()));
	
	}

	
}
