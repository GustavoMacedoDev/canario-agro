package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
