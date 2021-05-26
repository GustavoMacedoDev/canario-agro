package br.com.macedo.sistemas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.macedo.sistemas.domain.aggregate.Categoria;
import br.com.macedo.sistemas.domain.dto.CategoriaDto;
import br.com.macedo.sistemas.domain.service.CategoriaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	
	@GetMapping("/categorias")
	public List<Categoria> buscaCategorias() {
		return this.categoriaService.buscaCategorias();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(Long id) {
		Categoria categoria = categoriaService.findById(id);
		
		return ResponseEntity.ok().body(categoria);
	}

	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraCategoria(@Validated @RequestBody CategoriaDto categoriaDto) {
		
		Categoria categoria = categoriaService.fromDto(categoriaDto);
		categoria = categoriaService.insert(categoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getIdCategoria()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}
	
	

}
