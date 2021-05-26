package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
