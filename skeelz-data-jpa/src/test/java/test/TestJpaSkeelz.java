package test;

import Singleton.Singleton;
import repository.ISkeelzRepository;
import skeelz.modele.Skeelz;

public class TestJpaSkeelz {

	public static void main(String[] args) {
		
		ISkeelzRepository skeelzRepo = Singleton.getInstance().getSkeelzRepo();
		
		int startNumber = skeelzRepo.findAll().size();
		
		Skeelz skeelz1 = new Skeelz ();
		skeelz1.setIntitule("Skeelz 1 test");
		
		
		skeelz1 = skeelzRepo.save(skeelz1);
		
		
		
		skeelz1 = skeelzRepo.find(skeelz1.getId());
		
		System.out.println(skeelz1.getIntitule());
		
		int middleNumber = skeelzRepo.findAll().size();
		System.out.println(middleNumber - startNumber);
		
		skeelzRepo.delete(skeelz1);
		
	}

}
