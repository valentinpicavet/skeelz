package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import skeelz.modele.Cours;


public interface ICoursRepository extends JpaRepository<Cours, Long> {
//	@Query("select c from Cours c left join fetch c.module m left join fetch m.chapitre ch where c = :monCours")
//	List<Cours> findAllByCours(@Param("monCours") Cours cours);
	

	
//	@Query("select distinct m.cou from Module m join m.chapitre ch where ch = :chapitre")
//	List<Matiere> findAllByFiliere(@Param("filiere") Filiere filiere);
}

