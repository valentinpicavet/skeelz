package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Competence;
import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.repository.IBilanCompetenceRepository;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.ISkeelzRepository;
@SpringBootTest
public class TestRequeteBilanCompetence {



		
		@Autowired
		private IBilanCompetenceRepository bilanCompetenceRepo;
		@Autowired
		private IPersonneRepository personneRepo;
		@Autowired
		private ICompetenceRepository competenceRepo;
		@Autowired
		private ISkeelzRepository skeelzRepo;
		@Autowired
		private ICompetenceSkeelzRepository competenceSkeelzRepo;
		
		@Test
		public void testfindByPersonneAndEtatCours() {
			
			Skeelz objetConnecte = new Skeelz ();
			objetConnecte.setIntitule("skeelz requete");
			objetConnecte = skeelzRepo.save(objetConnecte);	
			
			Competence developpementDetecteurFume = new Competence();
			developpementDetecteurFume.setDescription("competence requete bilancompetence");
			developpementDetecteurFume.setIntitule("competence requete bilancompetence");
			developpementDetecteurFume.setPonderation(Ponderation.DIX);	
			developpementDetecteurFume = competenceRepo.save(developpementDetecteurFume);
			
			Personne personneValentin = new Personne();
			personneValentin.setNom("Picavet");
			personneValentin.setPrenom("Valentin");
			personneValentin.setTelephone("0624153698");	
			personneValentin = personneRepo.save(personneValentin);
			
			CompetenceSkeelz maCompetenceSkeelz = new CompetenceSkeelz();
			maCompetenceSkeelz.setCompetence(developpementDetecteurFume);
			maCompetenceSkeelz.setSkeelz(objetConnecte);
			maCompetenceSkeelz = competenceSkeelzRepo.save(maCompetenceSkeelz);
			
			BilanCompetence BilanValDete = new BilanCompetence();
			BilanValDete.setCompetenceSkeelz(maCompetenceSkeelz);
			BilanValDete.setPersonne(personneValentin);
			BilanValDete = bilanCompetenceRepo.save(BilanValDete);
		
		List<BilanCompetence> bilanVal = bilanCompetenceRepo.findByPersonne(personneValentin);
		assertEquals("skeelz requete", bilanVal.get(0).getCompetenceSkeelz().getSkeelz().getIntitule());
		
	}
}
