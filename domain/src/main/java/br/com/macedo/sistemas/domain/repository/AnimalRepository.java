package br.com.macedo.sistemas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.macedo.sistemas.domain.aggregate.Animal;


public interface AnimalRepository extends JpaRepository<Animal, Long> {

	@Query(value = "select * from animal a where a.em_estoque = true", nativeQuery = true)
	List<Animal> buscaAnimaisEmEstoque();
}
