package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Produtor;
import br.com.macedo.sistemas.domain.dto.ProdutorDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.ProdutorRepository;
import br.com.macedo.sistemas.domain.service.ProdutorService;

@Service
public class ProdutorServiceImpl implements ProdutorService {
	
	@Autowired
	private ProdutorRepository produtorRepository;

	@Override
	public List<Produtor> buscaProdutores() {
		return this.produtorRepository.findAll();
	}

	@Override
	public Produtor fromDto(ProdutorDto produtorDto) {
		return new Produtor(produtorDto.getRazaoSocial(), produtorDto.getNome());
	}

	@Override
	public Produtor insert(Produtor produtor) {
		produtor.setIdProdutor(null);
		return produtorRepository.save(produtor);
	}

	@Override
	public Produtor findById(Long id) {
		
		Optional<Produtor> produtor = produtorRepository.findById(id);
		
		return produtor.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produtor.class.getName()));
	}

}
