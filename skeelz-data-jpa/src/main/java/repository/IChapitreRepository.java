package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.Chapitre;

public interface IChapitreRepository extends JpaRepository<Chapitre, Long> {

}
