package sopra.skeelz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	@Query("from Utilisateur u where u.entreprise.id = :id")
	List<Utilisateur> findUtilisateurByIdEntreprise(@Param("id") Long id);

}
