package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Raca;
import br.com.macedo.sistemas.domain.dto.RacaDto;

public interface RacaService {
	
	List<Raca> buscaRacas();
	
	Raca fromDto(RacaDto racaDto);
	
	Raca insert(Raca raca);
	
	Raca findById(Long id);
	
	

}
