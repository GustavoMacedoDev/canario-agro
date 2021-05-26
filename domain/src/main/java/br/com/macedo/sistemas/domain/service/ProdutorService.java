package br.com.macedo.sistemas.domain.service;

import java.util.List;


import br.com.macedo.sistemas.domain.aggregate.Produtor;
import br.com.macedo.sistemas.domain.dto.ProdutorDto;

public interface ProdutorService {
	
	List<Produtor> buscaProdutores();
	
	Produtor fromDto(ProdutorDto produtorDto);
	
	Produtor insert(Produtor produtor);
	
	Produtor findById(Long id);

}
