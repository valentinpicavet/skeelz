package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Competence;

public interface ICompetenceRepository extends JpaRepository<Competence, Long> {

	@Query("from Competence c where c.entreprise.id = :id")
	List<Competence> findCompetenceByIdEntreprise(@Param("id") Long id);

	@Query("select distinct bc.competenceSkeelz.competence from BilanCompetence bc where bc.personne.id = :id")
	List<Competence> findCompetenceByIdPersonne(@Param("id") Long id);

}
