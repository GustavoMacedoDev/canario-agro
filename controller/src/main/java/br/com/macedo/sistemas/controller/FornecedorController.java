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

import br.com.macedo.sistemas.domain.aggregate.Fornecedor;
import br.com.macedo.sistemas.domain.dto.FornecedorDto;
import br.com.macedo.sistemas.domain.service.FornecedorService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("/fornecedores")
	public List<Fornecedor> buscaFornecedores() {
		return this.fornecedorService.buscaFornecedor();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> findById(Long id) {
		Fornecedor fornecedor = fornecedorService.findById(id);
		
		return ResponseEntity.ok().body(fornecedor);
	}

	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraFornecedor(@Validated @RequestBody FornecedorDto fornecedorDto) {
		
		Fornecedor fornecedor = fornecedorService.fromDto(fornecedorDto);
		fornecedor = fornecedorService.insert(fornecedor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(fornecedor.getIdFornecedor()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}

}
