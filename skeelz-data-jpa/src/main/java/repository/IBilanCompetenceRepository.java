package repository;



import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.BilanCompetence;

public interface IBilanCompetenceRepository extends JpaRepository<BilanCompetence, Long> {

}
