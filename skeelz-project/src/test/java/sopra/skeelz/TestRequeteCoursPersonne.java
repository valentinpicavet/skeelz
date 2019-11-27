package sopra.skeelz;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.ICoursPersonneRepository;
import repository.ICoursRepository;
import repository.IPersonneRepository;
import skeelz.modele.Cours;
import skeelz.modele.CoursPersonne;
import skeelz.modele.Difficulte;
import skeelz.modele.Etat;
import skeelz.modele.EtatCours;
import skeelz.modele.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class TestRequeteCoursPersonne {
	
	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private ICoursPersonneRepository coursPersonneRepo;
	
	@Test
	public void testfindByPersonneAndEtatCours() {
	Cours detecteurFume = new Cours ();
	detecteurFume.setIntitule("Concevez un détecteur de fumée connecté");
	detecteurFume.setDifficulte(Difficulte.FACILE);
	detecteurFume.setDuree(6);
	detecteurFume.setEtat(Etat.OUVERT);
	detecteurFume.setDescription("Dans ce cours, vous allez découvrir comment concevoir un objet connecté simple dans son contexte opérationnel : un détecteur de fumée connecté, depuis la définition des besoins jusqu’au prototypage.");
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
	
	List<CoursPersonne> coursVal = coursPersonneRepo.findByPersonneAndEtatCours(personneValentin, EtatCours.SUIVI);
	Assert.assertEquals("Concevez un détecteur de fumée connecté", coursVal.get(0).getCours().getIntitule());
	}
}
