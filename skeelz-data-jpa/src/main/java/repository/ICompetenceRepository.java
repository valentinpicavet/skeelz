package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.Competence;

public interface ICompetenceRepository extends JpaRepository<Competence, Long> {

}
