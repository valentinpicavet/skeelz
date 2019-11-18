package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.CoursPersonne;

public interface ICoursPersonneRepository extends JpaRepository<CoursPersonne, Long> {

}
