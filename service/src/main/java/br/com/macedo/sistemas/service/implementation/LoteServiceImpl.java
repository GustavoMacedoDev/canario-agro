package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Lote;
import br.com.macedo.sistemas.domain.dto.LoteNewDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.LoteRepository;
import br.com.macedo.sistemas.domain.service.LoteService;

@Service
public class LoteServiceImpl implements LoteService {
	
	@Autowired
	private LoteRepository loteRepository;

	@Override
	public List<Lote> buscaLotes() {
		return loteRepository.findAll();
	}

	@Override
	public Lote fromDto(LoteNewDto loteNewDto) {
		return new Lote(loteNewDto.getLote(), loteNewDto.getDataFabricacao(), 
				loteNewDto.getDataValidade());
	}

	@Override
	public Lote insert(Lote lote) {
		lote.setIdLote(null);
		return loteRepository.save(lote);
	}

	@Override
	public Lote findById(Long id) {
		Optional<Lote> lote = loteRepository.findById(id);
		
		return lote.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Lote.class.getName()));
	
	}

}
