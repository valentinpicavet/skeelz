package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Chapitre;

public interface IChapitreRepository extends JpaRepository<Chapitre, Long> {

//	@Query("from chapitre ch where ch.module.id = :id and ch.agencement = :agencementplus")
//	List<Chapitre> findAllByChapitre (@Param("id") Long chapitreId, @Param("agencementplus") Integer agencementChapitre);
//	
//	@Query("from chapitre ch where ch.module.id = :id and ch.agencement = :agencementmoins-1")
//	List<Chapitre> findAllByChapitre (@Param("id") Long chapitreId, @Param("agencementmoins") Integer agencementChapitre);

	@Query("from Chapitre ch where ch.module.id = :id")
	List<Chapitre> findChapitreByModuleId(@Param("id") Long id);

	@Query("from Chapitre c where c.agencement = :agencement and c.module.id = :idModule")
	Chapitre findChapitreByModuleAndAgencement(@Param("idModule") Long idModule, @Param("agencement") int agencement);

	@Query("from Chapitre c where c.module.cours.id = :id")
	List<Chapitre> findChapitre(@Param("id") Long id);
}
