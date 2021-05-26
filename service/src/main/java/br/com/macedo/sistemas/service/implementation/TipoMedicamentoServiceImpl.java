package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.TipoMedicamento;
import br.com.macedo.sistemas.domain.dto.TipoMedicamentoNewDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.TipoMedicamentoRepository;
import br.com.macedo.sistemas.domain.service.TipoMedicamentoService;

@Service
public class TipoMedicamentoServiceImpl implements TipoMedicamentoService {
	
	@Autowired
	private TipoMedicamentoRepository tipoMedicamentoRepository;

	@Override
	public List<TipoMedicamento> buscaTipoMedicamento() {
		return tipoMedicamentoRepository.findAll();
	}

	@Override
	public TipoMedicamento fromDto(TipoMedicamentoNewDto tipoMedicamentoNewDto) {
		return new TipoMedicamento(tipoMedicamentoNewDto.getTipo());
	}

	@Override
	public TipoMedicamento insert(TipoMedicamento tipoMedicamento) {
		tipoMedicamento.setIdTipoMedicamento(null);
		return tipoMedicamentoRepository.save(tipoMedicamento);
	}

	@Override
	public TipoMedicamento findById(Long id) {
		Optional<TipoMedicamento> tipoMedicamento = tipoMedicamentoRepository.findById(id);
		return tipoMedicamento.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoMedicamento.class.getName()));
	
	}
	
	

}
