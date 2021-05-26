package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Animal;


public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
