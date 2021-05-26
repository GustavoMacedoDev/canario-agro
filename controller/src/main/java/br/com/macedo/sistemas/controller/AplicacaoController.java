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

import br.com.macedo.sistemas.domain.aggregate.Aplicacao;
import br.com.macedo.sistemas.domain.dto.AplicacaoNewDto;
import br.com.macedo.sistemas.domain.service.AplicacaoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/aplicacao")
public class AplicacaoController {

	@Autowired
	private AplicacaoService aplicacaoService;
	
	@GetMapping("/aplicacoes")
	public List<Aplicacao> buscaTodas() {
		return this.aplicacaoService.buscaAplicacao();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aplicacao> findById(@PathVariable Long id) {
		Aplicacao aplicacao = aplicacaoService.findById(id);
		
		return ResponseEntity.ok().body(aplicacao);
	}
	
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraAplicacao(@Validated @RequestBody AplicacaoNewDto aplicacaoNewDto) {
		
		Aplicacao aplicacao = aplicacaoService.fromDto(aplicacaoNewDto);
		aplicacao = aplicacaoService.insert(aplicacao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(aplicacao.getIdAplicacao()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}

}
