package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.CoursCompetence;

public interface ICoursCompetenceRepository extends JpaRepository<CoursCompetence, Long> {
	
	@Query("from CoursCompetence cp where cp.cours.id = :id")
	List <CoursCompetence> findCoursCompetence(@Param("id") Long id);

}
