package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.CoursCompetence;

public interface ICoursCompetenceRepository extends JpaRepository<CoursCompetence, Long> {

}
