package br.com.macedo.sistemas.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.Medicamento;
import br.com.macedo.sistemas.domain.dto.MedicamentoNewDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.MedicamentoRepository;
import br.com.macedo.sistemas.domain.service.MedicamentoService;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@Override
	public List<Medicamento> buscaAnimais() {
		return this.medicamentoRepository.findAll();
	}

	@Override
	public Medicamento fromDto(MedicamentoNewDto medicamentoNewDto) {
		return new Medicamento(medicamentoNewDto.getNome(), medicamentoNewDto.getTipo());
	}

	@Override
	public Medicamento insert(Medicamento medicamento) {
		medicamento.setIdMedicamento(null);
		return medicamentoRepository.save(medicamento);
	}

	@Override
	public Medicamento findById(Long id) {
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
		return medicamento.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Medicamento.class.getName()));
	
	}

}
