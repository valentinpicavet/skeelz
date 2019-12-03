package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Entreprise;
import sopra.skeelz.model.Utilisateur;
import sopra.skeelz.repository.IEntrepriseRepository;
import sopra.skeelz.repository.IUtilisateurRepository;
import sopra.skeelz.web.UtilisateurController;

@SpringBootTest
public class TestJpaUtilisateur {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@Autowired
	private UtilisateurController utilisateurCont;

	@Autowired
	private IEntrepriseRepository entrepriseRepo;

	@Test
	public void testUtilisateur() {

		int startNumber = utilisateurRepo.findAll().size();

		Utilisateur user = new Utilisateur();
		user.setIdentifiant("Damien");
		user.setMail("testUtilisateur@yahoo.fr");
		user.setAdministrateur(false);
		user.setPassword("zboub");
		user.setRh(false);
		user.setSuperUser(false);

		user = utilisateurRepo.save(user);

		Optional<Utilisateur> userFind = utilisateurRepo.findById(user.getId());

		assertEquals("Damien", userFind.get().getIdentifiant());
		assertEquals("testUtilisateur@yahoo.fr", userFind.get().getMail());
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

	@Test
	public void testUtilisateurQuery() {

		Entreprise sopra = new Entreprise();
		sopra.setNom("testUtilisateurQuery");
		sopra.setNumeroSiret("testUtilisateurQuery");
		sopra.setTypeContrat("testUtilisateurQuery");
		sopra = entrepriseRepo.save(sopra);

		Utilisateur user = new Utilisateur();
		user.setIdentifiant("testUtilisateurQuery");
		user.setMail("testUtilisateurQuery@yahoo.fr");
		user.setAdministrateur(false);
		user.setPassword("testUtilisateurQuery");
		user.setRh(false);
		user.setEntreprise(sopra);
		user.setSuperUser(false);
		user = utilisateurRepo.save(user);

		assertEquals("testUtilisateurQuery",
				utilisateurRepo.findUtilisateurByIdEntreprise(sopra.getId()).get(0).getIdentifiant());

	}

	@Test
	public void testUtilisateurCont() {

		int startNumber = utilisateurCont.list().size();

		Entreprise sopra = new Entreprise();
		sopra.setNom("testUtilisateurCont");
		sopra.setNumeroSiret("testUtilisateurCont");
		sopra.setTypeContrat("testUtilisateurCont");
		sopra = entrepriseRepo.save(sopra);

		Utilisateur user = new Utilisateur();
		user.setIdentifiant("testUtilisateurCont");
		user.setMail("testUtilisateurCont@yahoo.fr");
		user.setAdministrateur(false);
		user.setPassword("testUtilisateurCont");
		user.setRh(false);
		user.setEntreprise(sopra);
		user.setSuperUser(false);
		user = utilisateurCont.create(user);
		user = utilisateurCont.update(user, user.getId());

		assertEquals("testUtilisateurCont", utilisateurCont.find(user.getId()).getIdentifiant());
		assertEquals("testUtilisateurCont", utilisateurCont.findEntrepriseByUtilisateurId(user.getId()).getNom());

		int middleNumber = utilisateurCont.list().size();
		assertEquals(1, (middleNumber - startNumber));

	}

	@Test
	public void testUtilisateurContBis() {

		Utilisateur user = new Utilisateur();
		user.setIdentifiant("testUtilisateurCont");
		user.setMail("testUtilisateurCont@yahoo.fr");
		user.setAdministrateur(false);
		user.setPassword("testUtilisateurCont");
		user.setRh(false);
		user.setSuperUser(false);
		user = utilisateurCont.create(user);
		utilisateurCont.delete(user.getId());
	}
}
