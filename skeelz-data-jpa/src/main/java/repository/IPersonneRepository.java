package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.Personne;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {

}
