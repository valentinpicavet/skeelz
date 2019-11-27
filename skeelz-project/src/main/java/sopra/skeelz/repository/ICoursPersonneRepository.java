package sopra.skeelz.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.Personne;

public interface ICoursPersonneRepository extends JpaRepository<CoursPersonne, Long> {

	List<CoursPersonne> findByPersonneAndEtatCours(Personne personne, EtatCours etatCours );
}
