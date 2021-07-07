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

import br.com.macedo.sistemas.domain.aggregate.Pessoa;
import br.com.macedo.sistemas.domain.dto.PessoaNewDto;
import br.com.macedo.sistemas.domain.service.PessoaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/pessoas")
	private List<Pessoa> listaPessoas() {
		return pessoaService.buscaPessoas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.findById(id);
		
		return ResponseEntity.ok().body(pessoa);
	}
	
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraPessoa(@Validated @RequestBody PessoaNewDto pessoaNewDto) {
		
		Pessoa pessoa = pessoaService.fromDto(pessoaNewDto);
		pessoa = pessoaService.insert(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pessoa.getIdPessoa()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}

}
