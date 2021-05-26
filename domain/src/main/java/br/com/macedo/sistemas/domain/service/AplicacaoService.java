package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Aplicacao;
import br.com.macedo.sistemas.domain.dto.AplicacaoNewDto;

public interface AplicacaoService {
	
	List<Aplicacao> buscaAplicacao();
	
	Aplicacao fromDto(AplicacaoNewDto aplicacaoNewDto);
	
	Aplicacao insert(Aplicacao aplicacao);
	
	Aplicacao findById(Long id);
	

}
