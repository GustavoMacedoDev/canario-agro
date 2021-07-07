package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Pessoa;
import br.com.macedo.sistemas.domain.dto.PessoaNewDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.PessoaRepository;
import br.com.macedo.sistemas.domain.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<Pessoa> buscaPessoas() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa fromDto(PessoaNewDto pessoaNewDto) {
		return new Pessoa(pessoaNewDto.getNome(), pessoaNewDto.getDocumento());
	}

	@Override
	public Pessoa insert(Pessoa pessoa) {
		pessoa.setIdPessoa(null);
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Pessoa findById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
	
	}

	
}
