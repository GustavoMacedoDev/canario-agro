package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Categoria;
import br.com.macedo.sistemas.domain.dto.CategoriaDto;


public interface CategoriaService {
	
	List<Categoria> buscaCategorias();
	
	Categoria fromDto(CategoriaDto categoriaDto);
	
	Categoria insert(Categoria categoria);
	
	Categoria findById(Long id);

}
