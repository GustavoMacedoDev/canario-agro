package br.com.macedo.sistemas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
	
	List<ItemVenda> findAllByIdVendaIdVenda(Long id);

}
