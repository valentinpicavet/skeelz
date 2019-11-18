package test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Singleton.Singleton;
import repository.IPersonneRepository;
import skeelz.modele.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class TestJpaPersonne {

	@Autowired
	private IPersonneRepository personneRepo;
	
	public void testPersonne() {
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
