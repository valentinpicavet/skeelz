package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Cours;


public interface ICoursRepository extends JpaRepository<Cours, Long> {
	


//	@Query ("from cours c where c.difficulte = :difficulte ")
//	List<Cours> findAllCoursByDifficulte(Difficulte difficulte);

	@Query ("select cc.cours from CoursCompetence cc order by cc.competence ")
	List<Cours> findAllCoursByCompetence();
	
	@Query ("select cc.cours from CoursCompetence cc join  cc.competence c join  c.competenceSkeelz cs order by cs.skeelz ")
	List<Cours> findAllCoursBySkeelz();
	
	@Query ("from Cours c order by c.duree")
	List<Cours> findAllCoursByDuree ();
	
	@Query("from Cours c where c.entreprise.id = :id")
	List<Cours> findCoursByIdEntreprise (@Param("id") Long id);
	
	@Query("select cp.cours from CoursPersonne cp where cp.personne.id = :id")
	List<Cours> findCoursByIdPersonne (@Param("id") Long id);

	
	
	
	
	
}
