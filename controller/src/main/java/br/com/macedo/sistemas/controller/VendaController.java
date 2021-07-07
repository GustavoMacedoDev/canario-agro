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

import br.com.macedo.sistemas.domain.aggregate.Venda;
import br.com.macedo.sistemas.domain.service.VendaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping("/vendas")
	public List<Venda> buscaVendas() {
		return vendaService.buscaVendas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venda> findById(@PathVariable Long id) {
		Venda venda = vendaService.findById(id);
		
		return ResponseEntity.ok().body(venda);
	}
	
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraVenda(@Validated @RequestBody Venda venda) {
		
		venda = vendaService.insert(venda);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(venda.getIdVenda()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}

}
