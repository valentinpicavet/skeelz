package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Utilisateur;
import sopra.skeelz.repository.IUtilisateurRepository;

@SpringBootTest
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

		assertEquals("Damien", userFind.get().getIdentifiant());
		assertEquals("docteurnichons@yahoo.fr", userFind.get().getMail());
		assertEquals(false, userFind.get().isAdministrateur());
		assertEquals(false, userFind.get().isRh());
		assertEquals(false, userFind.get().isSuperUser());
		assertEquals("zboub", userFind.get().getPassword());

		int middleNumber = utilisateurRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		utilisateurRepo.delete(user);

		int finalNumber = utilisateurRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);
	}
}
