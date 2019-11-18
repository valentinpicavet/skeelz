package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import skeelz.modele.Cours;

public interface ICoursRepository extends JpaRepository<Cours, Long> {
	@Query("from cours c left join fetch c.module m left join fetch m.chapitre ch where c = :cours")
	List<Cours> findAllByCours(@Param("cours") Cours cours);
}
