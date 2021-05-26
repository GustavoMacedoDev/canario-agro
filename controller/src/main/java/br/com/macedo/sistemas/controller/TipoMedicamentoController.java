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

import br.com.macedo.sistemas.domain.aggregate.TipoMedicamento;
import br.com.macedo.sistemas.domain.dto.TipoMedicamentoNewDto;
import br.com.macedo.sistemas.domain.service.TipoMedicamentoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tipoMedicamento")
public class TipoMedicamentoController {
	
	@Autowired
	private TipoMedicamentoService tipoMedicamentoService;
	
	@GetMapping("/tipos")
	private List<TipoMedicamento> buscaTipoMedicamentos(){
		return this.tipoMedicamentoService.buscaTipoMedicamento();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoMedicamento> findById(@PathVariable Long id) {
		TipoMedicamento tipoMedicamento = tipoMedicamentoService.findById(id);
		
		return ResponseEntity.ok().body(tipoMedicamento);
	}
	
	
	@PostMapping("/cadastra")
	public ResponseEntity<Void> cadastraTipoMedicamento(@Validated @RequestBody TipoMedicamentoNewDto tipoMedicamentoNewDto) {
		
		TipoMedicamento tipoMedicamento = tipoMedicamentoService.fromDto(tipoMedicamentoNewDto);
		tipoMedicamento = tipoMedicamentoService.insert(tipoMedicamento);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(tipoMedicamento.getIdTipoMedicamento()).toUri();
			return ResponseEntity.created(uri).build();
		
		
	}
	

}
