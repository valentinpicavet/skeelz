package sopra.skeelz;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IBilanCompetenceRepository;
import repository.ICompetenceRepository;

import repository.IPersonneRepository;
import repository.ISkeelzRepository;
import skeelz.modele.BilanCompetence;
import skeelz.modele.Competence;
import skeelz.modele.Personne;
import skeelz.modele.Ponderation;
import skeelz.modele.Skeelz;

public class TestRequeteBilanCompetence {

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = "/application-context.xml")
	public class TestRequeteCoursPersonne {
		
		@Autowired
		private IBilanCompetenceRepository bilanCompetenceRepo;
		@Autowired
		private IPersonneRepository personneRepo;
		@Autowired
		private ICompetenceRepository competenceRepo;
		@Autowired
		private ISkeelzRepository skeelzRepo;
		
		@Test
		public void testfindByPersonneAndEtatCours() {
			
			Skeelz objetConnecte = new Skeelz ();
			objetConnecte.setIntitule("Objet Connecté");
			objetConnecte = skeelzRepo.save(objetConnecte);	
			
			Competence developpementDetecteurFume = new Competence();
			developpementDetecteurFume.setDescription("Vous êtes capable de concevoir un détécteur de fumées connecté");
			developpementDetecteurFume.setIntitule("Développement d'un détecteur de fumée connecté");
			developpementDetecteurFume.setPonderation(Ponderation.DIX);	
			developpementDetecteurFume = competenceRepo.save(developpementDetecteurFume);
			
			Personne personneValentin = new Personne();
			personneValentin.setNom("Picavet");
			personneValentin.setPrenom("Valentin");
			personneValentin.setTelephone("0624153698");	
			personneValentin = personneRepo.save(personneValentin);
			
			BilanCompetence BilanValDete = new BilanCompetence();
			BilanValDete.setCompetence(developpementDetecteurFume);
			BilanValDete.setSkeelz(objetConnecte);
			BilanValDete.setPersonne(personneValentin);
			BilanValDete = bilanCompetenceRepo.save(BilanValDete);
		
		List<BilanCompetence> bilanVal = bilanCompetenceRepo.findByPersonne(personneValentin);
		Assert.assertEquals("Objet Connecté", bilanVal.get(0).getSkeelz().getIntitule());
		}
	}
}
