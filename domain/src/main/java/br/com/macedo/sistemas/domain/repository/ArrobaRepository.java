package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Arroba;

public interface ArrobaRepository extends JpaRepository<Arroba, Long>{

}
