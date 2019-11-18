package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import skeelz.modele.Cours;
import skeelz.modele.Module;

public interface IModuleRepository extends JpaRepository<Module, Long> {
	
	@Query("select m from Module m where m.cours = :cours")
	List<Module> findAllByCours(@Param("cours") Cours cours);
}
