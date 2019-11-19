package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import skeelz.modele.Cours;
import skeelz.modele.CoursPersonne;
import skeelz.modele.Difficulte;
import skeelz.modele.EtatCours;
import skeelz.modele.Personne;


public interface ICoursRepository extends JpaRepository<Cours, Long> {
	


//	@Query ("from cours c where c.difficulte = :difficulte ")
	List<Cours> findAllCoursByDifficulte(Difficulte difficulte);
	
	@Query ("select cc.cours from CoursCompetence cc order by cc.competence ")
	List<Cours> findAllCoursByCompetence();
	
	@Query ("select cc.cours from CoursCompetence cc join  cc.competence c join  c.competenceSkeelz cs order by cs.skeelz ")
	List<Cours> findAllCoursBySkeelz();
	
	@Query ("from Cours c order by c.duree")
	List<Cours> findAllCoursByDuree ();
	
	
	
	
	
	
}
