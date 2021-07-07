package br.com.macedo.sistemas.domain.service;

import java.util.List;

import br.com.macedo.sistemas.domain.aggregate.Pessoa;
import br.com.macedo.sistemas.domain.dto.PessoaNewDto;

public interface PessoaService {
	
	List<Pessoa> buscaPessoas();
	
	Pessoa fromDto(PessoaNewDto pessoaNewDto);
	
	Pessoa insert(Pessoa pessoa);
	
	Pessoa findById(Long id);
	

}
