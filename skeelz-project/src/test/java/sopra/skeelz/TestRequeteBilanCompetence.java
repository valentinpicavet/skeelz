package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Competence;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.repository.IBilanCompetenceRepository;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.ISkeelzRepository;

public class TestRequeteBilanCompetence {

	@SpringBootTest
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
		assertEquals("Objet Connecté", bilanVal.get(0).getSkeelz().getIntitule());
		}
	}
}
