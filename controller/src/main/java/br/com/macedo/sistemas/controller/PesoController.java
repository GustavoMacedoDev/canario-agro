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

import br.com.macedo.sistemas.domain.aggregate.Peso;
import br.com.macedo.sistemas.domain.service.PesoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/peso")
public class PesoController {

	@Autowired
	private PesoService pesoService;
	
	@GetMapping("/{id}")
	public List<Peso> buscaPesosAnimal (@PathVariable Long id){
		return pesoService.findByIdAnimal(id);
	}
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraPeso(@Validated @RequestBody Peso peso) {
		
		peso = pesoService.insert(peso);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(peso.getIdPeso()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}
}
