package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Cours;
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.EtatCours;

public interface ICoursPersonneRepository extends JpaRepository<CoursPersonne, Long> {

	@Query("from CoursPersonne cp where cp.personne.id = :idPersonne")
	List<CoursPersonne> findByIdPersonne(@Param("idPersonne") Long id);
	
	@Query("select cp.cours from CoursPersonne cp where cp.personne.id = :id and cp.etatCours = :etatCours")
	List<Cours> findCoursByIdPersonneEtatCours(@Param("id") Long id, @Param("etatCours") EtatCours etatCours);
	
	@Query("from CoursPersonne cp where cp.personne.id = :idPersonne and cp.cours.id = :idCours")
	CoursPersonne findCoursByIdPersonneAndIdCours(@Param("idPersonne") Long idPersonne, @Param("idCours") Long idCours);
}