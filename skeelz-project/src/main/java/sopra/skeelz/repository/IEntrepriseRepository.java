package sopra.skeelz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.skeelz.model.Entreprise;

public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long> {

	@Query("select u.entreprise from Utilisateur u where u.id = :id")
	Entreprise findEntrepriseByUtilisateur (@Param("id") Long id);
}
