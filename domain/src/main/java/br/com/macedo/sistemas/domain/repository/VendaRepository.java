package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

}
