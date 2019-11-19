package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import skeelz.modele.Chapitre;
import skeelz.modele.Cours;
import skeelz.modele.Module;

public interface IChapitreRepository extends JpaRepository<Chapitre, Long> {

//	@Query("from chapitre ch where ch.module.id = :id and ch.agencement = :agencementplus")
//	List<Chapitre> findAllByChapitre (@Param("id") Long chapitreId, @Param("agencementplus") Integer agencementChapitre);
//	
//	@Query("from chapitre ch where ch.module.id = :id and ch.agencement = :agencementmoins-1")
//	List<Chapitre> findAllByChapitre (@Param("id") Long chapitreId, @Param("agencementmoins") Integer agencementChapitre);
	
	@Query("from Chapitre ch join ch.module m where m.cours = :cours")
	List<Chapitre> findAllByCours (@Param("cours") Cours cours);
	
	@Query("from Chapitre ch where ch.module = :module")
	List<Chapitre> findAllByModule (@Param("module") Module module);
	
}
