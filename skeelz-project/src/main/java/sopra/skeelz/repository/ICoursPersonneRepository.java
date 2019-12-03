package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Cours;
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.EtatCours;

public interface ICoursPersonneRepository extends JpaRepository<CoursPersonne, Long> {

	@Query("select cp.cours from CoursPersonne cp where cp.personne.id = :id and cp.etatCours = :etatCours")
	List<Cours> findCoursByIdPersonneEtatCours(@Param("id") Long id, @Param("etatCours") EtatCours etatCours);
}