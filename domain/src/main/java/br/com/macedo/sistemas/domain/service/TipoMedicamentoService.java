package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.TipoMedicamento;
import br.com.macedo.sistemas.domain.dto.TipoMedicamentoNewDto;

public interface TipoMedicamentoService {
	
	List<TipoMedicamento> buscaTipoMedicamento();
	
	TipoMedicamento fromDto(TipoMedicamentoNewDto tipoMedicamentoNewDto);
	
	TipoMedicamento insert(TipoMedicamento tipoMedicamento);
	
	TipoMedicamento findById(Long id);

}
