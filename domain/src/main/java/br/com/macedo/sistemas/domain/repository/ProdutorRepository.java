package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Produtor;

public interface ProdutorRepository extends JpaRepository<Produtor, Long>{

}
