package sopra.skeelz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.skeelz.model.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long> {

}
