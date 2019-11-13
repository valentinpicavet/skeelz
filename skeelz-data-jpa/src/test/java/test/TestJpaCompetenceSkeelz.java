package test;

import Singleton.Singleton;
import repository.ICompetenceSkeelzRepository;
import skeelz.modele.CompetenceSkeelz;

public class TestJpaCompetenceSkeelz {

	public static void main(String[] args) {
		
		ICompetenceSkeelzRepository compsRepo = Singleton.getInstance().getCompetenceSkeelzRepo();
		
		int startNumber = compsRepo.findAll().size();
		
		CompetenceSkeelz comps = new CompetenceSkeelz();
		
		
		
		
		comps = compsRepo.save(comps);
		
		
		
		comps = compsRepo.find(comps.getId());
		
		
		int middleNumber = compsRepo.findAll().size();
		System.out.println(middleNumber - startNumber);
		
		compsRepo.delete(comps);
		
	}

}
