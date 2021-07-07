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

import br.com.macedo.sistemas.domain.aggregate.Arroba;
import br.com.macedo.sistemas.domain.service.ArrobaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/arroba")
public class ArrobaController {
	
	@Autowired
	private ArrobaService arrobaService;
	
	@GetMapping("/arrobas")
	public List<Arroba> buscaArrobas() {
		return arrobaService.buscaArrobas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Arroba> findById(@PathVariable Long id) {
		Arroba arroba  = arrobaService.findById(id);
		
		return ResponseEntity.ok().body(arroba);
	}

	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraArroba(@Validated @RequestBody Arroba arroba) {
		
		arroba = arrobaService.insert(arroba);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(arroba.getId()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}
	
	

}
