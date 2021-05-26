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

import br.com.macedo.sistemas.domain.aggregate.Raca;
import br.com.macedo.sistemas.domain.dto.RacaDto;
import br.com.macedo.sistemas.domain.service.RacaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/raca")
public class RacaController {
	
	@Autowired
	private RacaService racaService;
	
	@GetMapping("/racas")
	public List<Raca> listaRacas(){
		return this.racaService.buscaRacas();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Raca> findById(@PathVariable Long id) {
		Raca raca = racaService.findById(id);
		
		return ResponseEntity.ok().body(raca);
	}
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraRaca(@Validated @RequestBody RacaDto racaDto) {
		
		Raca raca = racaService.fromDto(racaDto);
		raca = racaService.insert(raca);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(raca.getIdRaca()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}

}
