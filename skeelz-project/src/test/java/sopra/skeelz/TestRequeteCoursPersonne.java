package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Cours;
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.Personne;
import sopra.skeelz.repository.ICoursPersonneRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IPersonneRepository;

@SpringBootTest
public class TestRequeteCoursPersonne {

	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private ICoursPersonneRepository coursPersonneRepo;

	@Test
	public void testfindByPersonneAndEtatCours() {
		Cours detecteurFume = new Cours();
		detecteurFume.setIntitule("coursccc");
		detecteurFume.setDifficulte(Difficulte.FACILE);
		detecteurFume.setDuree(6);
		detecteurFume.setEtat(Etat.OUVERT);
		detecteurFume.setDescription(
				"Dans ce cours, vous allez découvrir comment concevoir un objet connecté simple dans son contexte opérationnel : un détecteur de fumée connecté, depuis la définition des besoins jusqu’au prototypage.");
		detecteurFume.setCheminImageCours("Le chemin");
		detecteurFume = coursRepo.save(detecteurFume);

		Personne personneValentin = new Personne();
		personneValentin.setNom("Picavet");
		personneValentin.setPrenom("Valentin");
		personneValentin.setTelephone("0624153698");
		personneValentin = personneRepo.save(personneValentin);

		CoursPersonne valentinDetecteur = new CoursPersonne();
		valentinDetecteur.setEtatCours(EtatCours.SUIVI);
		valentinDetecteur.setCours(detecteurFume);
		valentinDetecteur.setPersonne(personneValentin);
		valentinDetecteur = coursPersonneRepo.save(valentinDetecteur);

		assertEquals("coursccc", coursPersonneRepo
				.findCoursByIdPersonneEtatCours(personneValentin.getId(), EtatCours.SUIVI).get(0).getIntitule());
	}
}
