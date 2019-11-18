package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.ElementDeCours;

public interface IElementDeCoursRepository extends JpaRepository<ElementDeCours, Long> {

}
