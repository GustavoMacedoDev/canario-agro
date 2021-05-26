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

import br.com.macedo.sistemas.domain.aggregate.Lote;
import br.com.macedo.sistemas.domain.dto.LoteNewDto;
import br.com.macedo.sistemas.domain.service.LoteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/lote")
public class LoteController {
	
	@Autowired
	private LoteService loteService;
	
	@GetMapping("/lotes")
	public List<Lote> buscaLotes() {
		return loteService.buscaLotes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lote> findById(@PathVariable Long id) {
		Lote lote = loteService.findById(id);
		
		return ResponseEntity.ok().body(lote);
	}
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraLote(@Validated @RequestBody LoteNewDto loteNewDto) {
		
		Lote lote = loteService.fromDto(loteNewDto);
		lote = loteService.insert(lote);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(lote.getIdLote()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}

}
