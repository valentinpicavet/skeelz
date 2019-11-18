package test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.IUtilisateurRepository;
import skeelz.modele.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")

public class UtilisateurRepositoryTest {

		
		IUtilisateurRepository userRepo = Singleton.getInstance().getUtilisateurRepo();
		
		int startNumber = userRepo.findAll().size();
		
		Utilisateur user = new Utilisateur();
		user.setIdentifiant("Damien");
		user.setMail("docteurnichons@yahoo.fr");
		user.setAdministrateur(false);
		user.setPassword("zboub");
		user.setRh(false);
		
		
		
		
		
		user = userRepo.save(user);
		
		
		
		user = userRepo.find(user.getId());
		
		System.out.println(user.getIdentifiant());
		
		int middleNumber = userRepo.findAll().size();
		System.out.println(middleNumber - startNumber);
		
		userRepo.delete(user);
		

}
