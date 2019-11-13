package test;

import Singleton.Singleton;
import repository.ICoursRepository;
import skeelz.modele.Cours;
import skeelz.modele.Difficulte;
import skeelz.modele.Etat;
import skeelz.modele.Skeelz;

public class TestJpaCours {

	public static void main(String[] args) {
		
		ICoursRepository coursRepo = Singleton.getInstance().getCoursRepo();
		
		int startNumber = coursRepo.findAll().size();
		
		Cours cours1 = new Cours ();
		cours1.setIntitule("java debutant");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		
		
		
		cours1 = coursRepo.save(cours1);
		
		
		
		cours1 = coursRepo.find(cours1.getId());
		
		System.out.println(cours1.getIntitule());
		System.out.println(cours1.getDifficulte());
		
		int middleNumber = coursRepo.findAll().size();
		System.out.println(middleNumber - startNumber);
		
		coursRepo.delete(cours1);
		
	}

}
