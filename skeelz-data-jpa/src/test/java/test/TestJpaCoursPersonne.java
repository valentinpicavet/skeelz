package test;

import java.util.List;

import Singleton.Singleton;
import repository.IBilanCompetenceRepository;
import repository.ICoursCompetenceRepository;
import repository.ICoursPersonneRepository;
import skeelz.modele.BilanCompetence;
import skeelz.modele.CoursCompetence;
import skeelz.modele.CoursPersonne;
import skeelz.modele.EtatCours;
import skeelz.modele.RelationCours;


public class TestJpaCoursPersonne {

	public static void main(String[] args) {
		ICoursPersonneRepository coursPersonneRepo = Singleton.getInstance().getCoursPersonneRepo();

		int startNumber = coursPersonneRepo.findAll().size();

		CoursPersonne monCoursPers = new CoursPersonne();
		monCoursPers.setEtatCours(EtatCours.VALIDE);
		
		monCoursPers = coursPersonneRepo.save(monCoursPers);


		CoursPersonne monCoursPersFind = coursPersonneRepo.find(monCoursPers.getId());
		System.out.println(monCoursPersFind);
		List<CoursPersonne> monCoursPersFindList = coursPersonneRepo.findAll();
		System.out.println(monCoursPersFindList.get(0));



		
		int middleNumber = coursPersonneRepo.findAll().size();
	
		System.out.println(middleNumber - startNumber);
		
		coursPersonneRepo.delete(monCoursPers);


	}

}
