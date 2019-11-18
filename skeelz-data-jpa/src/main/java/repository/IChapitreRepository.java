package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import skeelz.modele.Chapitre;

public interface IChapitreRepository extends JpaRepository<Chapitre, Long> {

//	@Query("from chapitre ch where ch.module.id = :id and ch.agencement = :agencementplus")
//	List<Chapitre> findAllByChapitre (@Param("id") Long chapitreId, @Param("agencementplus") Integer agencementChapitre);
//	
//	@Query("from chapitre ch where ch.module.id = :id and ch.agencement = :agencementmoins-1")
//	List<Chapitre> findAllByChapitre (@Param("id") Long chapitreId, @Param("agencementmoins") Integer agencementChapitre);
}
