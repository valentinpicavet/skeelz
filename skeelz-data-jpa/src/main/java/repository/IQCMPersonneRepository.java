package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.QCMPersonne;

public interface IQCMPersonneRepository extends JpaRepository<QCMPersonne, Long> {

}
