package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.BilanCompetence;

public interface IBilanCompetenceRepository extends JpaRepository<BilanCompetence, Long> {

	@Query("from BilanCompetence bc where bc.personne.id = :idPersonne")
	List<BilanCompetence> findByIdPersonne(@Param("idPersonne") Long idPersonne);
}
