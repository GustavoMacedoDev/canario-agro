package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Lote;

public interface LoteRepository extends JpaRepository<Lote, Long>{

}
