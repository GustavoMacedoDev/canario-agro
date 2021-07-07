package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Movimentacao;
import br.com.macedo.sistemas.domain.dto.MovimentacaoNewDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.MovimentacaoRepository;
import br.com.macedo.sistemas.domain.service.LoteService;
import br.com.macedo.sistemas.domain.service.MovimentacaoService;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private LoteService loteService;

	@Override
	public List<Movimentacao> buscaMovimentacao() {
		return movimentacaoRepository.findAll();
	}

	@Override
	public Movimentacao fromDto(MovimentacaoNewDto movimentacaoNewDto) {
		return new Movimentacao(movimentacaoNewDto.getDataMovimentacao(),
				movimentacaoNewDto.getTipo(), movimentacaoNewDto.getDosagem(), 
				movimentacaoNewDto.getMedicamento(), movimentacaoNewDto.getLote());
	}

	@Override
	public Movimentacao insert(Movimentacao movimentacao) {
		movimentacao.setIdMovimentacao(null);
		movimentacaoRepository.save(movimentacao);
		loteService.adicionaSaldo(movimentacao.getLote(), movimentacao.getDosagem());
		return movimentacao;
	}

	@Override
	public Movimentacao findById(Long id) {
		Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
		
		return movimentacao.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Movimentacao.class.getName()));
	}

}
