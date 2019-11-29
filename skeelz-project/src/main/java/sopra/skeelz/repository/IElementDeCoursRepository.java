package sopra.skeelz.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.ElementDeCours;


public interface IElementDeCoursRepository extends JpaRepository<ElementDeCours, Long> {
	
	@Query("from ElementDeCours edc where edc.agencement = :agencement and edc.chapitre.id = :idChapitre")
	ElementDeCours findElementDeCoursByChapitreAndAgencement(@Param("idChapitre") Long idChapitre, @Param("agencement") int agencement );
	
	@Query("from ElementDeCours edc where edc.chapitre.id = :idChapitre")
	List<ElementDeCours> findElementDeCours(@Param("idChapitre") Long idChapitre);
	

}
