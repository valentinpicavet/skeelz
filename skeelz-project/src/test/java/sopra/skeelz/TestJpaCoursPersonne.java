package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

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
import sopra.skeelz.web.CoursPersonneController;

@SpringBootTest
public class TestJpaCoursPersonne {

	@Autowired
	private ICoursPersonneRepository CoursPersonneRepo;
	@Autowired
	private CoursPersonneController coursPersonneCont;
	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private IPersonneRepository personneRepo;

	@Test
	public void testCoursPersonne() {

		int startNumber = CoursPersonneRepo.findAll().size();

		CoursPersonne coursPersonne1 = new CoursPersonne();

		coursPersonne1.setEtatCours(EtatCours.VALIDE);

		coursPersonne1 = CoursPersonneRepo.save(coursPersonne1);

		Optional<CoursPersonne> coursPersonne1Find = CoursPersonneRepo.findById(coursPersonne1.getId());

		assertEquals(EtatCours.VALIDE, coursPersonne1Find.get().getEtatCours());

		int middleNumber = CoursPersonneRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		CoursPersonneRepo.delete(coursPersonne1);

		int finalNumber = CoursPersonneRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

	@Test
	public void testCoursPersonneQuery() {

		Personne personne = new Personne();
		personne.setNom("nomCoursPersonneQuery");
		personne.setPrenom("prenomCoursPersonneQuery");
		personne = personneRepo.save(personne);

		Cours cours = new Cours();
		cours.setDifficulte(Difficulte.FACILE);
		cours.setDescription("descriptionCOursPersonneQuery");
		cours.setEtat(Etat.OUVERT);
		cours.setDuree(5);
		cours.setIntitule("intituleCoursPersonneQuery");
		cours = coursRepo.save(cours);

		CoursPersonne coursPersonne1 = new CoursPersonne();
		coursPersonne1.setEtatCours(EtatCours.VALIDE);
		coursPersonne1.setCours(cours);
		coursPersonne1.setPersonne(personne);
		coursPersonne1 = CoursPersonneRepo.save(coursPersonne1);

		assertEquals("intituleCoursPersonneQuery", CoursPersonneRepo
				.findCoursByIdPersonneEtatCours(personne.getId(), EtatCours.VALIDE).get(0).getIntitule());
	}

	@Test
	public void testCoursPersonneController() {

		int startNumber = coursPersonneCont.list().size();

		Personne personne = new Personne();
		personne.setNom("nomCoursPersonneCont");
		personne.setPrenom("prenomCoursPersonneCont");
		personne = personneRepo.save(personne);

		Cours cours = new Cours();
		cours.setDifficulte(Difficulte.FACILE);
		cours.setDescription("descriptionCOursPersonneCont");
		cours.setEtat(Etat.OUVERT);
		cours.setDuree(5);
		cours.setIntitule("intituleCoursPersonneCont");
		cours = coursRepo.save(cours);

		CoursPersonne coursPersonne1 = new CoursPersonne();
		coursPersonne1.setEtatCours(EtatCours.VALIDE);
		coursPersonne1.setCours(cours);
		coursPersonne1.setPersonne(personne);
		coursPersonne1 = coursPersonneCont.create(coursPersonne1);
		coursPersonne1 = coursPersonneCont.update(coursPersonne1, coursPersonne1.getId());

		assertEquals("intituleCoursPersonneCont",
				coursPersonneCont.find(personne.getId(), EtatCours.VALIDE).get(0).getIntitule());
		assertEquals(EtatCours.VALIDE, coursPersonneCont.find(coursPersonne1.getId()).getEtatCours());

		int middleNumber = coursPersonneCont.list().size();
		assertEquals(1, (middleNumber - startNumber));

	}

	@Test
	public void testCoursPersonneControllerBis() {

		CoursPersonne coursPersonne1 = new CoursPersonne();
		coursPersonne1.setEtatCours(EtatCours.VALIDE);
		coursPersonne1 = coursPersonneCont.create(coursPersonne1);

		coursPersonneCont.delete(coursPersonne1.getId());
	}

}
