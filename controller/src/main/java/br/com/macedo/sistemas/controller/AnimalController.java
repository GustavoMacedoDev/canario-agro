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

import br.com.macedo.sistemas.domain.aggregate.Animal;
import br.com.macedo.sistemas.domain.dto.AnimalNewDto;
import br.com.macedo.sistemas.domain.service.AnimalService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@GetMapping("/animais")
	public List<Animal> buscaAnimais() {
		return this.animalService.buscaAnimais();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Animal> findById(@PathVariable Long id) {
		Animal animal = animalService.findById(id);
		
		return ResponseEntity.ok().body(animal);
	}
	
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraAnimal(@Validated @RequestBody AnimalNewDto animalNewDto) {
		
		Animal animal = animalService.fromDto(animalNewDto);
		animal = animalService.insert(animal);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(animal.getIdAnimal()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}

}
