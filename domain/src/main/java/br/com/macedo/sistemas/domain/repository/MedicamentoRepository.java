package br.com.macedo.sistemas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.macedo.sistemas.domain.aggregate.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{

}
