package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Categoria;
import br.com.macedo.sistemas.domain.dto.CategoriaDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.CategoriaRepository;
import br.com.macedo.sistemas.domain.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> buscaCategorias() {
		return this.categoriaRepository.findAll();
	}

	@Override
	public Categoria insert(Categoria categoria) {
		categoria.setIdCategoria(null);
		
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	
	}


	@Override
	public Categoria fromDto(CategoriaDto categoriaDto) {
		return new Categoria(categoriaDto.getNome());
	}

}
