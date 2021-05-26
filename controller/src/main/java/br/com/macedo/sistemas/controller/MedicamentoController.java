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

import br.com.macedo.sistemas.domain.aggregate.Medicamento;
import br.com.macedo.sistemas.domain.dto.MedicamentoNewDto;
import br.com.macedo.sistemas.domain.service.MedicamentoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@GetMapping("/medicamentos")
	private List<Medicamento> listaTodos() {
		return this.medicamentoService.buscaAnimais();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> findById(@PathVariable Long id) {
		Medicamento medicamento = medicamentoService.findById(id);
		
		return ResponseEntity.ok().body(medicamento);
	}
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraMedicamento(@Validated @RequestBody MedicamentoNewDto medicamentoNewDto) {
		
		Medicamento medicamento = medicamentoService.fromDto(medicamentoNewDto);
		medicamento = medicamentoService.insert(medicamento);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(medicamento.getIdMedicamento()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}
}
