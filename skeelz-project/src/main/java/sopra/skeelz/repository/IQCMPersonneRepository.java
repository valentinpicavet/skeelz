package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.QCMPersonne;

public interface IQCMPersonneRepository extends JpaRepository<QCMPersonne, Long> {

	@Query("from QCMPersonne q join q.module m join m.cours c where q.personne.id = :idPersonne and c.id = :idCours")
	List<QCMPersonne> findByPersonneIdAndIdCours(@Param("idPersonne") Long idPersonne, @Param("idCours") Long idCours);
	
	@Query("from QCMPersonne q where q.personne.id = :personne and q.module.id = :module")
	QCMPersonne findByPersonneAndModule(@Param("personne") Long personne, @Param("module") Long module);
	
	@Query("from QCMPersonne q where q.personne.id = :idPersonne")
	List<QCMPersonne> findByPersonneId(@Param("idPersonne") Long idPersonne);

}
