package sopra.skeelz;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.IUtilisateurRepository;
import skeelz.modele.Utilisateur;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")

public class TestJpaUtilisateur {
	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	
	@Test
	public void testUtilisateur() {
	
		
		int startNumber = utilisateurRepo.findAll().size();
		
		Utilisateur user = new Utilisateur();
		user.setIdentifiant("Damien");
		user.setMail("docteurnichons@yahoo.fr");
		user.setAdministrateur(false);
		user.setPassword("zboub");
		user.setRh(false);
		user.setSuperUser(false);
		
		user = utilisateurRepo.save(user);
		
		Optional<Utilisateur> userFind = utilisateurRepo.findById(user.getId());
	
		Assert.assertEquals("Damien", userFind.get().getIdentifiant());
		Assert.assertEquals("docteurnichons@yahoo.fr", userFind.get().getMail());
		Assert.assertEquals(false, userFind.get().isAdministrateur());
		Assert.assertEquals(false, userFind.get().isRh());
		Assert.assertEquals(false, userFind.get().isSuperUser());
		Assert.assertEquals("zboub", userFind.get().getPassword());
		
		
		int middleNumber = utilisateurRepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		utilisateurRepo.delete(user);
		
		int finalNumber = utilisateurRepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
	}
}
