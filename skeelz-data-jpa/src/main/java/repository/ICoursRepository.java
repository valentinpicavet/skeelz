package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.Cours;

public interface ICoursRepository extends JpaRepository<Cours, Long> {
	

}
