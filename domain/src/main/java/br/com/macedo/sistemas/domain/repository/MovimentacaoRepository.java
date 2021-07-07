package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{

}
