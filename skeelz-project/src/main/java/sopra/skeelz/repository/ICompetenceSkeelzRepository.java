package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.RelationCours;

public interface ICompetenceSkeelzRepository extends JpaRepository<CompetenceSkeelz, Long> {

	@Query("from CompetenceSkeelz cs join cs.bilanCompetence bc where bc.personne.id = :idPersonne")
	List<CompetenceSkeelz> findByIdPersonne (@Param("idPersonne") Long idPersonne);
	
	@Query("from CompetenceSkeelz cs join cs.competence c join c.coursCompetence cc where cc.cours.id = :idCours and cc.relationCours = :relationCours")
	List<CompetenceSkeelz> findByIdCoursAndRelationCours(@Param("idCours") Long idCours, @Param("relationCours") RelationCours relationCours);
}
