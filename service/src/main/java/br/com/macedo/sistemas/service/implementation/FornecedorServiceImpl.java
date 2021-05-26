package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Fornecedor;
import br.com.macedo.sistemas.domain.dto.FornecedorDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.FornecedorRepository;
import br.com.macedo.sistemas.domain.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Override
	public List<Fornecedor> buscaFornecedor() {
		return this.fornecedorRepository.findAll();
	}

	@Override
	public Fornecedor fromDto(FornecedorDto fornecedorDto) {
		return new Fornecedor(fornecedorDto.getNome(), fornecedorDto.getDocumento());
	}

	@Override
	public Fornecedor insert(Fornecedor fornecedor) {
		fornecedor.setIdFornecedor(null);
		
		return fornecedorRepository.save(fornecedor);
	}

	@Override
	public Fornecedor findById(Long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return fornecedor.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Fornecedor.class.getName()));
	
	}
	
	

}
