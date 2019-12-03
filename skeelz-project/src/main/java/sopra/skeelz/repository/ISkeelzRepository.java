package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Skeelz;

public interface ISkeelzRepository extends JpaRepository<Skeelz, Long> {

	@Query("from Skeelz s where s.entreprise.id = :id")
	List<Skeelz> findSkeelzByIdEntreprise(@Param("id") Long id);

	@Query("select bc.competenceSkeelz.skeelz from BilanCompetence bc where bc.personne.id = :id")
	List<Skeelz> findSkeelzByIdPersonne(@Param("id") Long id);

}
