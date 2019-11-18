package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
