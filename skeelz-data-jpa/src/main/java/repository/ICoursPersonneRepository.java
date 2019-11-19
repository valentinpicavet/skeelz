package repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.CoursPersonne;
import skeelz.modele.EtatCours;
import skeelz.modele.Personne;

public interface ICoursPersonneRepository extends JpaRepository<CoursPersonne, Long> {

	List<CoursPersonne> findByPersonneAndEtatCours(Personne personne, EtatCours etatCours );
}
