package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.TipoMedicamento;

public interface TipoMedicamentoRepository extends JpaRepository<TipoMedicamento, Long>{

}
