package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Medicamento;
import br.com.macedo.sistemas.domain.dto.MedicamentoNewDto;

public interface MedicamentoService {
	
	List<Medicamento> buscaAnimais();
	
	Medicamento fromDto(MedicamentoNewDto medicamentoNewDto);
	
	Medicamento insert(Medicamento medicamento);
	
	Medicamento findById(Long id);
	

}
