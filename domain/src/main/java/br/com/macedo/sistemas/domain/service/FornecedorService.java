package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Fornecedor;
import br.com.macedo.sistemas.domain.dto.FornecedorDto;

public interface FornecedorService {
	
	List<Fornecedor> buscaFornecedor();
	
	Fornecedor fromDto(FornecedorDto fornecedorDto);
	
	Fornecedor insert(Fornecedor fornecedor);
	
	Fornecedor findById(Long id);
	

}
