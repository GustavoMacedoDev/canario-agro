package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Venda;
import br.com.macedo.sistemas.domain.dto.VendaNewDto;

public interface VendaService {
	
	List<Venda> buscaVendas();
	
	Venda fromDto(VendaNewDto vendaNewDto);
	
	Venda insert(Venda venda);
	
	Venda findById(Long id);

}
