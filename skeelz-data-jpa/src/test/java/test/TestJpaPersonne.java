package test;

import java.util.List;

import Singleton.Singleton;
import repository.IPersonneRepository;
import skeelz.modele.Personne;


public class TestJpaPersonne {

	public static void main(String[] args) {
		IPersonneRepository personneRepo = Singleton.getInstance().getPersonneRepo();

		int startNumber = personneRepo.findAll().size();

		Personne maPersonne = new Personne();
		maPersonne.setNom("JEAN");
		maPersonne.setPrenom("Jean");
		maPersonne.setTelephone("026134515");
		
		
		maPersonne = personneRepo.save(maPersonne);


		Personne maPersonneFind = personneRepo.find(maPersonne.getId());
		System.out.println(maPersonneFind);
		List<Personne> maPersonneFindList = personneRepo.findAll();
		System.out.println(maPersonneFindList.get(0));



		
		int middleNumber = personneRepo.findAll().size();
	
		System.out.println(middleNumber - startNumber);
		
		personneRepo.delete(maPersonne);


	}

}
