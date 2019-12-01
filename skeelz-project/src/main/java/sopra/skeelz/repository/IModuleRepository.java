package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Module;

public interface IModuleRepository extends JpaRepository<Module, Long> {
	
	@Query("select m from Module m where m.cours.id = :id")
	List<Module> findModule(@Param("id") Long id);
	
	@Query("select distinct m from Module m left join fetch m.chapitres ch where m.cours.id = :id")
	List<Module> findModulesWithChapitres(@Param("id") Long id);
	
	@Query("from Module m where m.agencement = :agencement and m.cours.id = :idCours")
	Module findModuleByCoursAndAgencement(@Param("idCours") Long idCours, @Param("agencement") int agencement );


}
