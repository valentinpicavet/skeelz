package sopra.skeelz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.skeelz.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
