package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Chapitre;
import sopra.skeelz.model.Competence;
import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.Cours;
import sopra.skeelz.model.CoursCompetence;
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Entreprise;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.Module;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.model.RelationCours;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.repository.IChapitreRepository;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.repository.ICoursCompetenceRepository;
import sopra.skeelz.repository.ICoursPersonneRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IEntrepriseRepository;
import sopra.skeelz.repository.IModuleRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.ISkeelzRepository;
import sopra.skeelz.web.CoursController;

@SpringBootTest
public class TestJpaCours {

	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private IEntrepriseRepository entrepriseRepo;
	@Autowired
	private ISkeelzRepository skeelzRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;
	@Autowired
	private ICoursCompetenceRepository coursCompetenceRepo;
	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;
	@Autowired
	private ICoursPersonneRepository coursPersonneRepo;
	@Autowired
	private IModuleRepository moduleRepo;
	@Autowired
	private IChapitreRepository chapitreRepo;
	@Autowired
	private CoursController coursCont;

	@Test
	public void testCours() {

		int startNumber = coursRepo.findAll().size();

		Cours cours1 = new Cours();

		cours1.setIntitule("java debutant");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("chemin");
		cours1.setDescription("description");

		cours1 = coursRepo.save(cours1);

		Optional<Cours> cours1Find = coursRepo.findById(cours1.getId());

		assertEquals("java debutant", cours1Find.get().getIntitule());
		assertEquals(Difficulte.FACILE, cours1Find.get().getDifficulte());

		int middleNumber = coursRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		coursRepo.delete(cours1);

		int finalNumber = coursRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

	@Test
	public void testCoursQuery() {

		int startNumberEtat = coursRepo.findAllCoursByEtat(Etat.OUVERT).size();
		int startNumberDifficulte = coursRepo.findAllCoursByDifficulte(Difficulte.FACILE).size();
		int startNumberDuree = coursRepo.findAllCoursByDuree(5).size();

		Personne personne = new Personne();
		personne.setNom("personneCOursQuery");
		personne.setPrenom("personneCoursQuery");
		personne = personneRepo.save(personne);

		Entreprise entreprise = new Entreprise();
		entreprise.setNom("entrepriseCoursQuery");
		entreprise.setNumeroSiret("SiretCoursQuery");
		entreprise.setTypeContrat("contratCoursQuery");
		entreprise = entrepriseRepo.save(entreprise);

		Competence competence = new Competence();
		competence.setIntitule("competenceCoursQuery");
		competence.setPonderation(Ponderation.CINQ);
		competence.setDescription("competenceCoursQuery");
		competence = competenceRepo.save(competence);

		Skeelz skeelz = new Skeelz();
		skeelz.setIntitule("skeelzCoursQuery");
		skeelz = skeelzRepo.save(skeelz);

		CompetenceSkeelz competenceSkeelz = new CompetenceSkeelz();
		competenceSkeelz.setCompetence(competence);
		competenceSkeelz.setSkeelz(skeelz);
		competenceSkeelz = competenceSkeelzRepo.save(competenceSkeelz);

		Cours cours1 = new Cours();
		cours1.setIntitule("intituleCoursQuery");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("chemin");
		cours1.setDescription("descriptionCoursQuery");
		cours1.setEntreprise(entreprise);
		cours1 = coursCont.create(cours1);
		cours1 = coursCont.update(cours1, cours1.getId());

		CoursCompetence coursCompetence = new CoursCompetence();
		coursCompetence.setCompetence(competence);
		coursCompetence.setCours(cours1);
		coursCompetence.setRelationCours(RelationCours.VALIDE);
		coursCompetence = coursCompetenceRepo.save(coursCompetence);

		CoursPersonne coursPersonne = new CoursPersonne();
		coursPersonne.setCours(cours1);
		coursPersonne.setPersonne(personne);
		coursPersonne.setEtatCours(EtatCours.VALIDE);
		coursPersonne = coursPersonneRepo.save(coursPersonne);

		assertEquals("intituleCoursQuery", coursRepo.findCoursByIdEntreprise(entreprise.getId()).get(0).getIntitule());
		assertEquals("intituleCoursQuery", coursRepo.findCoursByIdPersonne(personne.getId()).get(0).getIntitule());
		assertEquals("intituleCoursQuery", coursRepo.findCoursBySkeelz(skeelz.getId()).get(0).getIntitule());
		assertEquals("intituleCoursQuery", coursRepo.findAllCoursByIntitule("intituleCoursQuery").get(0).getIntitule());
		assertEquals("intituleCoursQuery", coursRepo
				.findAllCoursByCompetenceAndRelationCours(competence.getId(), coursCompetence.getRelationCours()).get(0)
				.getIntitule());

		int finalNumberEtat = coursRepo.findAllCoursByEtat(Etat.OUVERT).size();
		int finalNumberDifficulte = coursRepo.findAllCoursByDifficulte(Difficulte.FACILE).size();
		int finalNumberDuree = coursRepo.findAllCoursByDuree(5).size();

		assertEquals(1, finalNumberEtat - startNumberEtat);
		assertEquals(1, finalNumberDifficulte - startNumberDifficulte);
		assertEquals(1, finalNumberDuree - startNumberDuree);

	}

	@Test
	public void testCoursController() {

		int startNumber = coursCont.list().size();
		int startNumberEtat = coursCont.findByEtat("OUVERT").size();
		int startNumberDifficulte = coursCont.find(Difficulte.FACILE).size();

		Personne personne = new Personne();
		personne.setNom("personneCOursCont");
		personne.setPrenom("personneCoursCont");
		personne = personneRepo.save(personne);

		Entreprise entreprise = new Entreprise();
		entreprise.setNom("entrepriseCoursCont");
		entreprise.setNumeroSiret("SiretCoursCont");
		entreprise.setTypeContrat("contratCoursCont");
		entreprise = entrepriseRepo.save(entreprise);

		Competence competence = new Competence();
		competence.setIntitule("competenceCoursCont");
		competence.setPonderation(Ponderation.CINQ);
		competence.setDescription("competenceCoursCont");
		competence = competenceRepo.save(competence);

		Skeelz skeelz = new Skeelz();
		skeelz.setIntitule("skeelzCoursCont");
		skeelz = skeelzRepo.save(skeelz);

		CompetenceSkeelz competenceSkeelz = new CompetenceSkeelz();
		competenceSkeelz.setCompetence(competence);
		competenceSkeelz.setSkeelz(skeelz);
		competenceSkeelz = competenceSkeelzRepo.save(competenceSkeelz);

		Cours cours1 = new Cours();
		cours1.setIntitule("intituleCoursCont");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("chemin");
		cours1.setDescription("descriptionCoursCont");
		cours1.setEntreprise(entreprise);
		cours1 = coursCont.create(cours1);
		cours1 = coursCont.update(cours1, cours1.getId());

		CoursCompetence coursCompetence = new CoursCompetence();
		coursCompetence.setCompetence(competence);
		coursCompetence.setCours(cours1);
		coursCompetence.setRelationCours(RelationCours.VALIDE);
		coursCompetence = coursCompetenceRepo.save(coursCompetence);

		CoursPersonne coursPersonne = new CoursPersonne();
		coursPersonne.setCours(cours1);
		coursPersonne.setPersonne(personne);
		coursPersonne.setEtatCours(EtatCours.VALIDE);
		coursPersonne = coursPersonneRepo.save(coursPersonne);

		Module module = new Module();
		module.setCours(cours1);
		module.setIntitule("moduleCoursCont");
		module.setAgencement(3);
		module = moduleRepo.save(module);

		Chapitre chapitre = new Chapitre();
		chapitre.setModule(module);
		chapitre.setAgencement(6);
		chapitre.setTitre("titreCoursCont");
		chapitre = chapitreRepo.save(chapitre);

		assertEquals("moduleCoursCont", coursCont.findModule(cours1.getId()).get(0).getIntitule());
		assertEquals(6,
				coursCont.findModulesWithChapitres(cours1.getId()).get(0).getChapitres().get(0).getAgencement());
		assertEquals(6, coursCont.findChapitre(cours1.getId()).get(0).getAgencement());
		assertEquals("intituleCoursCont", coursCont.find("intituleCoursCont").get(0).getIntitule());
		assertEquals("intituleCoursCont", coursCont.find(cours1.getId()).getIntitule());

		int finalNumber = coursCont.list().size();
		int finalNumberEtat = coursCont.findByEtat("OUVERT").size();
		int finalNumberDifficulte = coursCont.find(Difficulte.FACILE).size();

		assertEquals(1, finalNumber - startNumber);
		assertEquals(1, finalNumberEtat - startNumberEtat);
		assertEquals(1, finalNumberDifficulte - startNumberDifficulte);

	}

	@Test
	public void testCoursControllerBis() {
		Cours cours1 = new Cours();
		cours1.setIntitule("intituleCoursContBis");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("chemin");
		cours1.setDescription("descriptionCoursContBis");
		cours1 = coursCont.create(cours1);
		cours1 = coursCont.update(cours1, cours1.getId());

		coursCont.delete(cours1.getId());
	}

}
