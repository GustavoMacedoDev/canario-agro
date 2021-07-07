package br.com.macedo.sistemas.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.macedo.sistemas.domain.aggregate.ItemVenda;
import br.com.macedo.sistemas.domain.aggregate.Venda;
import br.com.macedo.sistemas.domain.dto.VendaNewDto;
import br.com.macedo.sistemas.domain.exception.ObjectNotFoundException;
import br.com.macedo.sistemas.domain.repository.ItemVendaRepository;
import br.com.macedo.sistemas.domain.repository.VendaRepository;
import br.com.macedo.sistemas.domain.service.AnimalService;
import br.com.macedo.sistemas.domain.service.PessoaService;
import br.com.macedo.sistemas.domain.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private PessoaService pessoaService;

	@Override
	public List<Venda> buscaVendas() {
		return vendaRepository.findAll();
	}

	@Override
	public Venda fromDto(VendaNewDto vendaNewDto) {
		return null;
	}

	@Override
	public Venda insert(Venda venda) {
		
		venda.setIdVenda(null);
		venda.setDataVenda(new Date());
		venda.setPessoa(pessoaService.findById(venda.getPessoa().getIdPessoa()));
		
		venda = vendaRepository.save(venda);
		
		for (ItemVenda ip : venda.getItens()) {
			ip.setAnimal(animalService.findById(ip.getAnimal().getId()));
			ip.setValorItem(ip.getValorItem());
			ip.setVenda(venda);
		}
		
		
	
		itemVendaRepository.saveAll(venda.getItens());
		
		animalService.atualizaEstoqueAnimais(venda);
		
		return venda;
	}

	@Override
	public Venda findById(Long id) {
		Optional<Venda> venda = vendaRepository.findById(id);
		return venda.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Venda.class.getName()));
	
	}

}
