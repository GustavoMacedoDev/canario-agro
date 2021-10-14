package br.com.macedo.sistemas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.macedo.sistemas.domain.aggregate.Animal;


public interface AnimalRepository extends JpaRepository<Animal, Long> {

	@Query(value = "select * from animal where status = ?1", nativeQuery = true)
	List<Animal> buscaAnimaisDisponiveis(String status);
	
	@Query(value = "select * from animal where status = 'DISPONIVEL' OR status = 'BLOQUEADO' ", nativeQuery = true)
	List<Animal> buscaAnimaisEmEstoque();
	
	@Query(value = "select * from animal where sexo = ?1 ", nativeQuery = true)
	List<Animal> buscaAnimaisPorSexo(String sexo);
	
	
}
