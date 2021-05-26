package br.com.macedo.sistemas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.macedo.sistemas.domain.aggregate.Produtor;
import br.com.macedo.sistemas.domain.dto.ProdutorDto;
import br.com.macedo.sistemas.domain.service.ProdutorService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/produtor")
public class ProdutorController {
	
	@Autowired
	private ProdutorService produtorService;
	
	@GetMapping("/produtores")
	public List<Produtor> buscaProdutores(){
		return this.produtorService.buscaProdutores();
	}

	@GetMapping("{id}")
	public ResponseEntity<Produtor> findById(@PathVariable Long id) {
		Produtor produtor = this.produtorService.findById(id);
		
		return ResponseEntity.ok().body(produtor);
	}
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> insert(@Validated @RequestBody ProdutorDto produtorDto) {
		Produtor produtor = produtorService.fromDto(produtorDto);
		
		produtor = produtorService.insert(produtor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(produtor.getIdProdutor()).toUri();
			return ResponseEntity.created(uri).build();
		
	}
}
