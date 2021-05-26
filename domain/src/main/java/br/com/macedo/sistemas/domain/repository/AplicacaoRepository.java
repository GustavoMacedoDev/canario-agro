package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Aplicacao;

public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long>{

}
