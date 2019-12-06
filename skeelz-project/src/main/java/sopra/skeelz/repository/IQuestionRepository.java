package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long> {

	@Query("select distinct q from Question q join fetch q.reponses r where q.module.id = :id")
	List<Question> findQuestionAndReponse(@Param("id") Long id);
}
