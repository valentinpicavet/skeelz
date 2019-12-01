package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Competence;
import sopra.skeelz.model.Cours;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Entreprise;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.model.Utilisateur;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IEntrepriseRepository;
import sopra.skeelz.repository.ISkeelzRepository;
import sopra.skeelz.repository.IUtilisateurRepository;
import sopra.skeelz.web.EntrepriseController;

@SpringBootTest
public class TestJpaEntreprise {

	@Autowired
	private IEntrepriseRepository entrepriseRepo;
	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	@Autowired
	private ISkeelzRepository skeelzRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;
	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private EntrepriseController entrepriseCont;
	
	@Test
	public void testEntreprise() {
	
	int startNumber = entrepriseRepo.findAll().size();
	
	Entreprise sopra = new Entreprise();
	sopra.setNom("Sopra Steria");
	sopra.setNumeroSiret("ST0045");
	sopra.setTypeContrat("Contrat de ouf");
	
	sopra = entrepriseRepo.save(sopra);
	
	Optional<Entreprise>sopraFind = entrepriseRepo.findById(sopra.getId());
	
	assertEquals("Sopra Steria", sopraFind.get().getNom());
	assertEquals("ST0045", sopraFind.get().getNumeroSiret());
	assertEquals("ST0045", sopraFind.get().getNumeroSiret());
	
	int middleNumber = entrepriseRepo.findAll().size();
	
	assertEquals(1, (middleNumber - startNumber));
	
	entrepriseRepo.delete(sopra);
	
	int finalNumber = entrepriseRepo.findAll().size();
	
	assertEquals(0, (finalNumber - startNumber));

	
	}
	
	@Test
	public void testEntrepriseQuery() {
	

	
	Entreprise sopra = new Entreprise();
	sopra.setNom("nomEntrepriseQuery");
	sopra.setNumeroSiret("siretEntrepriseQuery");
	sopra.setTypeContrat("contratEntrepriseQuery");
	sopra = entrepriseRepo.save(sopra);
	
	
	Utilisateur utilisateur = new Utilisateur();
	utilisateur.setEntreprise(sopra);
	utilisateur.setIdentifiant("identifiantEntrpriseQuery");
	utilisateur.setMail("mail@entrepriseQuery.fr");
	utilisateur.setPassword("codeEntrepriseQuery");
	utilisateur = utilisateurRepo.save(utilisateur);
	
	assertEquals("nomEntrepriseQuery", entrepriseRepo.findEntrepriseByUtilisateur(utilisateur.getId()).getNom());
	}
	
	@Test
	public void testEntrepriseCont() {
	
	int startNumber = entrepriseCont.list().size();
	
	Entreprise sopra = new Entreprise();
	sopra.setNom("identifiantEntrpriseCont");
	sopra.setNumeroSiret("siretEntrepriseCont");
	sopra.setTypeContrat("contratEntrepriseCont");
	sopra = entrepriseCont.create(sopra);
	sopra = entrepriseCont.update(sopra, sopra.getId());
	
	Utilisateur utilisateur = new Utilisateur();
	utilisateur.setEntreprise(sopra);
	utilisateur.setIdentifiant("identifiantEntrpriseCont");
	utilisateur.setMail("mail@entrepriseCont.fr");
	utilisateur.setPassword("codeEntrepriseCont");
	utilisateur = utilisateurRepo.save(utilisateur);
	
	Cours cours = new Cours();
	cours.setDescription("descriptionEntrepriseCont");
	cours.setIntitule("intituleEntrepriseCont");
	cours.setDifficulte(Difficulte.DIFFICILE);
	cours.setDuree(3);
	cours.setEntreprise(sopra);
	cours.setEtat(Etat.OUVERT);
	cours = coursRepo.save(cours);
	
	Skeelz skeelz = new Skeelz();
	skeelz.setEntreprise(sopra);
	skeelz.setIntitule("intituleEntrepriseCont");
	skeelz = skeelzRepo.save(skeelz);
	
	Competence competence = new Competence();
	competence.setDescription("descriptionEntrepriseCont");
	competence.setEntreprise(sopra);
	competence.setPonderation(Ponderation.CINQ);
	competence.setIntitule("intituleEntrepriseCont");
	competence = competenceRepo.save(competence);
	
	
	assertEquals("identifiantEntrpriseCont", entrepriseCont.find(sopra.getId()).getNom());
	assertEquals("descriptionEntrepriseCont", entrepriseCont.findCours(sopra.getId()).get(0).getDescription());
	assertEquals("intituleEntrepriseCont", entrepriseCont.findSkeelz(sopra.getId()).get(0).getIntitule());
	assertEquals("intituleEntrepriseCont", entrepriseCont.findCompetence(sopra.getId()).get(0).getIntitule());
	assertEquals("identifiantEntrpriseCont", entrepriseCont.findUtilisateur(sopra.getId()).get(0).getIdentifiant());


	
	int middleNumber = entrepriseCont.list().size();
	
	assertEquals(1, (middleNumber - startNumber));
		
	}
	
	@Test
	public void testEntrepriseContBis() {
		Entreprise sopra = new Entreprise();
		sopra.setNom("identifiantEntrpriseCont");
		sopra.setNumeroSiret("siretEntrepriseCont");
		sopra.setTypeContrat("contratEntrepriseCont");
		sopra = entrepriseCont.create(sopra);
		entrepriseCont.delete(sopra.getId());
	}
}
