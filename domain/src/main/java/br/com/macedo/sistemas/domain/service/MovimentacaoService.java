package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Movimentacao;
import br.com.macedo.sistemas.domain.dto.MovimentacaoNewDto;

public interface MovimentacaoService {
	
	List<Movimentacao> buscaMovimentacao();
	
	Movimentacao fromDto(MovimentacaoNewDto movimentacaoNewDto);
	
	Movimentacao insert(Movimentacao movimentacao);
	
	Movimentacao findById(Long id);
	

}
