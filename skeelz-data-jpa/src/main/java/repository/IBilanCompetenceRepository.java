package repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.BilanCompetence;
import skeelz.modele.Personne;

public interface IBilanCompetenceRepository extends JpaRepository<BilanCompetence, Long> {

	List<BilanCompetence> findByPersonne(Personne personne);
}
