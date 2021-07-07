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

import br.com.macedo.sistemas.domain.aggregate.Movimentacao;
import br.com.macedo.sistemas.domain.dto.MovimentacaoNewDto;
import br.com.macedo.sistemas.domain.service.MovimentacaoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@GetMapping("/movimentacoes")
	public List<Movimentacao> buscaMovimentacoes() {
		return movimentacaoService.buscaMovimentacao();
	}
	
	@GetMapping("/id")
	public ResponseEntity<Movimentacao> findById(@PathVariable Long id) {
		Movimentacao movimentacao = movimentacaoService.findById(id);
		
		return ResponseEntity.ok().body(movimentacao);
	}
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> lancaMovimentacao(@Validated @RequestBody MovimentacaoNewDto movimentacaoNewDto){
		Movimentacao movimentacao = movimentacaoService.fromDto(movimentacaoNewDto);
		movimentacao = movimentacaoService.insert(movimentacao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(movimentacao.getIdMovimentacao()).toUri();
			return ResponseEntity.created(uri).build();
		
	}

}
