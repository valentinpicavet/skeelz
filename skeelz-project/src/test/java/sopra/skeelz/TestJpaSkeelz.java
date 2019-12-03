package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Competence;
import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.Cours;
import sopra.skeelz.model.CoursCompetence;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Entreprise;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.model.RelationCours;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.repository.IBilanCompetenceRepository;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.repository.ICoursCompetenceRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IEntrepriseRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.ISkeelzRepository;
import sopra.skeelz.web.SkeelzController;

@SpringBootTest
public class TestJpaSkeelz {

	@Autowired
	private ISkeelzRepository skeelzRepo;
	@Autowired
	private SkeelzController skeelzCont;
	@Autowired
	private IEntrepriseRepository entrepriseRepo;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;
	@Autowired
	private IBilanCompetenceRepository bilanCompetenceRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;
	@Autowired
	private ICoursCompetenceRepository coursCompetenceRepo;
	@Autowired
	private ICoursRepository coursRepo;

	@Test
	public void testSkeelz() {

		int startNumber = skeelzRepo.findAll().size();

		Skeelz skeelz1 = new Skeelz();

		skeelz1.setIntitule("Skeelz 1 test");

		skeelz1 = skeelzRepo.save(skeelz1);

		Optional<Skeelz> skeelz1Find = skeelzRepo.findById(skeelz1.getId());

		assertEquals("Skeelz 1 test", skeelz1Find.get().getIntitule());

		int middleNumber = skeelzRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		skeelzRepo.delete(skeelz1);

		int finalNumber = skeelzRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

	@Test
	public void testSkeelzQuery() {

		Personne personne = new Personne();
		personne.setNom("testSkeelzQuery");
		personne.setPrenom("testSkeelzQuery");
		personne = personneRepo.save(personne);

		Entreprise monEntreprise = new Entreprise();
		monEntreprise.setNom("testSkeelzQuery");
		monEntreprise.setNumeroSiret("testSkeelzQuery");
		monEntreprise.setTypeContrat("testSkeelzQuery");
		monEntreprise = entrepriseRepo.save(monEntreprise);

		Skeelz skeelz1 = new Skeelz();
		skeelz1.setIntitule("testSkeelzQuery");
		skeelz1.setEntreprise(monEntreprise);
		skeelz1 = skeelzRepo.save(skeelz1);

		CompetenceSkeelz competenceSkeelz = new CompetenceSkeelz();
		competenceSkeelz.setSkeelz(skeelz1);
		competenceSkeelz = competenceSkeelzRepo.save(competenceSkeelz);

		BilanCompetence bilanCompetence = new BilanCompetence();
		bilanCompetence.setPersonne(personne);
		bilanCompetence.setCompetenceSkeelz(competenceSkeelz);
		bilanCompetence = bilanCompetenceRepo.save(bilanCompetence);

		assertEquals("testSkeelzQuery",
				skeelzRepo.findSkeelzByIdEntreprise(monEntreprise.getId()).get(0).getIntitule());
		assertEquals("testSkeelzQuery", skeelzRepo.findSkeelzByIdPersonne(personne.getId()).get(0).getIntitule());

	}

	@Test
	public void testSkeelzCont() {

		int startNumber = skeelzCont.list().size();

		Entreprise monEntreprise = new Entreprise();
		monEntreprise.setNom("testSkeelzCont");
		monEntreprise.setNumeroSiret("testSkeelzCont");
		monEntreprise.setTypeContrat("testSkeelzCont");
		monEntreprise = entrepriseRepo.save(monEntreprise);

		Cours cours1 = new Cours();
		cours1.setIntitule("testSkeelzCont");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("testSkeelzCont");
		cours1.setDescription("testSkeelzCont");
		cours1.setEntreprise(monEntreprise);
		cours1 = coursRepo.save(cours1);

		Competence competence = new Competence();
		competence.setIntitule("testSkeelzCont");
		competence.setPonderation(Ponderation.CINQ);
		competence.setDescription("testSkeelzCont");
		competence = competenceRepo.save(competence);

		CoursCompetence coursCompetence = new CoursCompetence();
		coursCompetence.setCompetence(competence);
		coursCompetence.setCours(cours1);
		coursCompetence.setRelationCours(RelationCours.VALIDE);
		coursCompetence = coursCompetenceRepo.save(coursCompetence);

		Personne personne = new Personne();
		personne.setNom("testSkeelzCont");
		personne.setPrenom("testSkeelzCont");
		personne = personneRepo.save(personne);

		Skeelz skeelz1 = new Skeelz();
		skeelz1.setIntitule("testSkeelzCont");
		skeelz1.setEntreprise(monEntreprise);
		skeelz1 = skeelzCont.create(skeelz1);
		skeelz1 = skeelzCont.update(skeelz1, skeelz1.getId());

		CompetenceSkeelz competenceSkeelz = new CompetenceSkeelz();
		competenceSkeelz.setSkeelz(skeelz1);
		competenceSkeelz.setCompetence(competence);
		competenceSkeelz = competenceSkeelzRepo.save(competenceSkeelz);

		BilanCompetence bilanCompetence = new BilanCompetence();
		bilanCompetence.setPersonne(personne);
		bilanCompetence.setCompetenceSkeelz(competenceSkeelz);
		bilanCompetence = bilanCompetenceRepo.save(bilanCompetence);

		assertEquals("testSkeelzCont", skeelzCont.find(skeelz1.getId()).getIntitule());
		assertEquals("testSkeelzCont", skeelzCont.findPersonneBySkeelzId(skeelz1.getId()).get(0).getNom());
		assertEquals("testSkeelzCont", skeelzCont.findCoursBySkeelzId(skeelz1.getId()).get(0).getIntitule());

		int middleNumber = skeelzCont.list().size();
		assertEquals(1, (middleNumber - startNumber));

	}

	@Test
	public void testSkeelzContBis() {
		Skeelz skeelz1 = new Skeelz();
		skeelz1.setIntitule("testSkeelzContBis");
		skeelz1 = skeelzCont.create(skeelz1);
		skeelzCont.delete(skeelz1.getId());
	}
}
