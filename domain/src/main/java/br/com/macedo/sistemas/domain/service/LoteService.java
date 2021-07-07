package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Lote;
import br.com.macedo.sistemas.domain.dto.LoteNewDto;

public interface LoteService {
	
	List<Lote> buscaLotes();
	
	Lote fromDto(LoteNewDto loteNewDto);
	
	Lote insert(Lote lote);
	
	Lote findById(Long id);
	
	void adicionaSaldo(Lote lote, Double quantidade);
	
	void diminuiSaldo(Lote lote, Double quantidade);
	
	

}
