package sopra.skeelz.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Personne;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {
	
	@Query("select bc.personne from BilanCompetence bc where bc.skeelz.id = :id")
	List<Personne> findCoursByIdPersonne (@Param("id") Long id);
	
	@Query("select distinct bc.personne from BilanCompetence bc where bc.competence.id = :id")
	List<Personne> findPersonneByIdCompetence(@Param("id") Long id);

}
