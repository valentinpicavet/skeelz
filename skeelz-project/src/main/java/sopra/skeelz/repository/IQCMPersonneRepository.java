package sopra.skeelz.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.QCMPersonne;

public interface IQCMPersonneRepository extends JpaRepository<QCMPersonne, Long> {
	
	@Query("from QCMPersonne q where q.personne.id = :personne and q.module.id = :module")
	QCMPersonne findByPersonneAndModule (@Param("personne") Long personne, @Param("module") Long module);

}
