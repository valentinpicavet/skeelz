package sopra.skeelz.repository;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Cours;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.RelationCours;
import sopra.skeelz.model.Skeelz;

public interface ICoursRepository extends JpaRepository<Cours, Long> {

	@Query("from Cours c where c.duree = :duree")
	List<Cours> findAllCoursByDuree(@Param("duree") int duree);

	@Query("from Cours c where c.entreprise.id = :id")
	List<Cours> findCoursByIdEntreprise(@Param("id") Long id);

	@Query("select cp.cours from CoursPersonne cp where cp.personne.id = :id and cp.etatCours = :etatCours")
	List<Cours> findCoursByIdPersonne(@Param("id") Long id,@Param("etatCours") EtatCours etatCours);

	@Query("select distinct cc.cours from CoursCompetence cc join cc.competence c join  c.competenceSkeelz cs where cs.skeelz.id = :id and cc.cours.etat= :etat")
	List<Cours> findCoursBySkeelzEtat(@Param("id") Long id,@Param("etat") Etat etat);
	
	@Query("select distinct cc.cours from CoursCompetence cc join cc.competence c join  c.competenceSkeelz cs where cs.skeelz.id = :id")
	List<Cours> findCoursBySkeelz(@Param("id") Long id);
	
	@Query("select distinct c.difficulte from Cours c where c.difficulte !=null")
	List<Difficulte> findAllDiff();

	
	
	
	// ***********************VM

	@Query("from Cours c where c.etat = :etat")
	List<Cours> findAllCoursByEtat(@Param("etat") Etat etat);

	@Query("from Cours c where c.difficulte = :difficulte and c.etat = :etat")
	List<Cours> findAllCoursByDifficulteEtat(@Param("difficulte") Difficulte difficulte,@Param("etat") Etat etat);
	
	@Query("from Cours c where c.difficulte = :difficulte ")
	List<Cours> findAllCoursByDifficulte(@Param("difficulte") Difficulte difficulte);

	@Query("from Cours c where c.intitule = :intitule")
	List<Cours> findAllCoursByIntitule(@Param("intitule") String intitule);

	@Query("select distinct cc.cours from CoursCompetence cc where cc.competence.id = :id and cc.relationCours = :relationCours")
	List<Cours> findAllCoursByCompetenceAndRelationCours(@Param("id") Long id,
			@Param("relationCours") RelationCours relationCours);
	
	/*
	 * public static void storeFile(MultipartFile file) throws IOException { Path
	 * filePath = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());
	 * 
	 * Files.copy(file.getInputStream(), filePath,
	 * StandardCopyOption.REPLACE_EXISTING); }
	 */

}
