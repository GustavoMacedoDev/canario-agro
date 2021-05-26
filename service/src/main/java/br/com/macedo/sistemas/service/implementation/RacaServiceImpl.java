package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Raca;
import br.com.macedo.sistemas.domain.dto.RacaDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.RacaRepository;
import br.com.macedo.sistemas.domain.service.RacaService;

@Service
public class RacaServiceImpl implements RacaService{
	
	@Autowired
	private RacaRepository racaRepository;

	@Override
	public List<Raca> buscaRacas() {
		return this.racaRepository.findAll();
	}

	@Override
	public Raca fromDto(RacaDto racaDto) {
		return new Raca(racaDto.getNome());
		
	}

	@Override
	public Raca insert(Raca raca) {
		raca.setIdRaca(null);
		
		return racaRepository.save(raca);
	}

	@Override
	public Raca findById(Long id) {
		Optional<Raca> raca = racaRepository.findById(id);
		return raca.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Raca.class.getName()));
	
	}

}
