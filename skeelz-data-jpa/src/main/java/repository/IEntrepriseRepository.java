package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.Entreprise;

public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
