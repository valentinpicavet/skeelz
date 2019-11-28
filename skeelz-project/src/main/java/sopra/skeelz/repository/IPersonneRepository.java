package sopra.skeelz.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.skeelz.model.Personne;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {
	
	@Query("select bc.personne from BilanCompetence bc where bc.skeelz.id = :id")
	List<Personne> findCoursByIdPersonne (@Param("id") Long id);

	
	
}
