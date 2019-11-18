package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import skeelz.modele.Module;

public interface IModuleRepository extends JpaRepository<Module, Long> {

}
