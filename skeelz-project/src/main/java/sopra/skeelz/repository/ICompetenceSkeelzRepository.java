package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.CompetenceSkeelz;

public interface ICompetenceSkeelzRepository extends JpaRepository<CompetenceSkeelz, Long> {

	@Query("from CompetenceSkeelz cs join cs.bilanCompetence bc where bc.personne.id = :idPersonne")
	List<CompetenceSkeelz> findByIdPersonne (@Param("idPersonne") Long idPersonne);
}
