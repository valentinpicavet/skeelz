package sopra.skeelz.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import sopra.skeelz.model.Personne;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {

}
