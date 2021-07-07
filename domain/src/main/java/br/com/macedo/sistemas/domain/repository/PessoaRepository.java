package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
