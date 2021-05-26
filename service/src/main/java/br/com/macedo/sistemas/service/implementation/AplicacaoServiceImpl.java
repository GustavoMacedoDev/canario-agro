package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Aplicacao;
import br.com.macedo.sistemas.domain.dto.AplicacaoNewDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.AplicacaoRepository;
import br.com.macedo.sistemas.domain.service.AplicacaoService;

@Service
public class AplicacaoServiceImpl implements AplicacaoService {
	
	@Autowired
	private AplicacaoRepository aplicacaoRepository;

	@Override
	public List<Aplicacao> buscaAplicacao() {
		return aplicacaoRepository.findAll();
	}

	@Override
	public Aplicacao fromDto(AplicacaoNewDto aplicacaoNewDto) {
		return new Aplicacao(aplicacaoNewDto.getDataAplicacao(),
				aplicacaoNewDto.getAnimal(), aplicacaoNewDto.getMedicamento());
	}

	@Override
	public Aplicacao insert(Aplicacao aplicacao) {
		aplicacao.setIdAplicacao(null);
		
		return aplicacaoRepository.save(aplicacao);
	}

	@Override
	public Aplicacao findById(Long id) {
		Optional<Aplicacao> aplicacao = aplicacaoRepository.findById(id);
		return aplicacao.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aplicacao.class.getName()));
	
	}

}
