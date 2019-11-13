package test;

import java.util.List;

import Singleton.Singleton;
import repository.IBilanCompetenceRepository;
import skeelz.modele.BilanCompetence;


public class TestJpaBilanCompetence {

	public static void main(String[] args) {
		IBilanCompetenceRepository bilanCompetenceRepo = Singleton.getInstance().getBilanCompetenceRepo();

		int startNumber = bilanCompetenceRepo.findAll().size();

		BilanCompetence monBilan = new BilanCompetence();
		
		monBilan = bilanCompetenceRepo.save(monBilan);


		BilanCompetence monBilanFind = bilanCompetenceRepo.find(monBilan.getId());
		System.out.println(monBilanFind);
		List<BilanCompetence> monBilanFindList = bilanCompetenceRepo.findAll();
		System.out.println(monBilanFindList.get(0));



		
		int middleNumber = bilanCompetenceRepo.findAll().size();
	
		System.out.println(middleNumber - startNumber);
		
		bilanCompetenceRepo.delete(monBilan);


	}

}
