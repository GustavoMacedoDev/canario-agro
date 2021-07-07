package br.com.macedo.sistemas.domain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.macedo.sistemas.domain.aggregate.Peso;

public interface PesoRepository extends JpaRepository<Peso, Long>{
	
	@Query(value = "select * from peso p where p.animal_id_animal = ?1", nativeQuery = true)
	List<Peso> findAllByAnimalId(Long id);

	@Query(value = "select * from peso p where p.id_peso = ?1 AND p.data_registro = ?2", nativeQuery = true)
	Peso validaCadastro(Long id, Date dataRegistro);
	
	@Query(value = "select Max(data_registro), peso_atual from peso where animal_id_animal = ?1 group by peso_atual", nativeQuery = true)
	Double buscaPesoAtualByIdAnimal(Long id);
}
