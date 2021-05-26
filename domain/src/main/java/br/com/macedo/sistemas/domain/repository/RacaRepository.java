package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Raca;

public interface RacaRepository extends JpaRepository<Raca, Long>{

}
