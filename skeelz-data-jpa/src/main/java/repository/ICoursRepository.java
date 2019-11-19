package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import skeelz.modele.Competence;
import skeelz.modele.Cours;
import skeelz.modele.Difficulte;


public interface ICoursRepository extends JpaRepository<Cours, Long> {
	

//	@Query("from cours c left join fetch c.module m left join fetch m.chapitre ch where c = :cours")
//	List<Cours> findAllByCours(@Param("cours") Cours cours);
//	
//	@Query ("from cours c where c.difficulte = :difficulte ")
	List<Cours> findAllCoursByDifficulte(Difficulte difficulte);
//	
	@Query ("select cc.cours from CoursCompetence cc order by cc.competence ")
	List<Cours> findAllCoursByCompetence();
	
	@Query ("select cc.cours from CoursCompetence cc join  cc.competence c join  c.competenceSkeelz cs order by cs.skeelz ")
	List<Cours> findAllCoursBySkeelz();
	
//	
//	@Query ("from cours c order by c.duree")
//	List<Cours> findAllCoursByDuree ();
//	
//	@Query ("from cours")
//	List<Cours> findAllCoursByDifficulte(@Param("difficulte")Difficulte difficulte);
	
	
}
