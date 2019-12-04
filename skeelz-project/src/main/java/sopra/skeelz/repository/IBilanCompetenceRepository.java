package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Personne;

public interface IBilanCompetenceRepository extends JpaRepository<BilanCompetence, Long> {

	List<BilanCompetence> findByPersonne(Personne personne);
}
