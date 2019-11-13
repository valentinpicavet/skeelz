package test;

import java.util.List;

import Singleton.Singleton;
import repository.ICoursCompetenceRepository;
import skeelz.modele.CoursCompetence;
import skeelz.modele.RelationCours;


public class TestJpaCoursCompetence {

	public static void main(String[] args) {
		ICoursCompetenceRepository coursCompetenceRepo = Singleton.getInstance().getCoursCompetenceRepo();

		int startNumber = coursCompetenceRepo.findAll().size();

		CoursCompetence monCoursComp = new CoursCompetence();
		monCoursComp.setRelationCours(RelationCours.VALIDE);;
		
		monCoursComp = coursCompetenceRepo.save(monCoursComp);


		CoursCompetence monCoursCompFind = coursCompetenceRepo.find(monCoursComp.getId());
		System.out.println(monCoursCompFind);
		List<CoursCompetence> monCoursCompFindList = coursCompetenceRepo.findAll();
		System.out.println(monCoursCompFindList.get(0));



		
		int middleNumber = coursCompetenceRepo.findAll().size();
	
		System.out.println(middleNumber - startNumber);
		
		coursCompetenceRepo.delete(monCoursComp);


	}

}
