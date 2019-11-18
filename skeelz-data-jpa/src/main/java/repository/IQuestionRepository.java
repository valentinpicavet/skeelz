package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long> {

}
