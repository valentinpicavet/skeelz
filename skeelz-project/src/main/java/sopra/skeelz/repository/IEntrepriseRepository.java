package sopra.skeelz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.skeelz.model.Entreprise;

public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
