package test;

import java.util.List;

import Singleton.Singleton;

import repository.ICompetenceRepository;
import skeelz.modele.Competence;
import skeelz.modele.Ponderation;



public class TestJpaCompetence {

	public static void main(String[] args) {
		ICompetenceRepository competenceRepo = Singleton.getInstance().getCompetenceRepo();

		int startNumber = competenceRepo.findAll().size();

		Competence maCompetence = new Competence();
		maCompetence.setDescription("trop bien");
		maCompetence.setIntitule("java pour les null");
		maCompetence.setPonderation(Ponderation.DIX);
		
		maCompetence = competenceRepo.save(maCompetence);


		Competence maCompetenceFind = competenceRepo.find(maCompetence.getId());
		System.out.println(maCompetenceFind.getPonderation().getLabel());
		List<Competence> maCompetenceFindList = competenceRepo.findAll();
		System.out.println(maCompetenceFindList.get(0));



		
		int middleNumber = competenceRepo.findAll().size();
	
		System.out.println(middleNumber - startNumber);
		
		competenceRepo.delete(maCompetence);


	}

}
