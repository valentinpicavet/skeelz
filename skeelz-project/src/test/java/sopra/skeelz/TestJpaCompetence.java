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
import sopra.skeelz.repository.IBilanCompetenceRepository;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.repository.ICoursCompetenceRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IEntrepriseRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.web.CompetenceController;

@SpringBootTest
public class TestJpaCompetence {

	@Autowired
	private ICompetenceRepository competenceRepo;
	@Autowired
	private IEntrepriseRepository entrepriseRepo;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;
	@Autowired
	private IBilanCompetenceRepository bilanCompetenceRepo;
	@Autowired
	private CompetenceController competenceCont;
	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private ICoursCompetenceRepository coursCompetenceRepo;

	@Test
	public void testCompetence() {

		int startNumber = competenceRepo.findAll().size();

		Competence maCompetence = new Competence();
		maCompetence.setDescription("trop bien");
		maCompetence.setIntitule("java pour les null");
		maCompetence.setPonderation(Ponderation.DIX);

		maCompetence = competenceRepo.save(maCompetence);

		Optional<Competence> maCompetenceFind = competenceRepo.findById(maCompetence.getId());

		assertEquals("java pour les null", maCompetenceFind.get().getIntitule());
		assertEquals("trop bien", maCompetenceFind.get().getDescription());
		assertEquals(Ponderation.DIX, maCompetenceFind.get().getPonderation());

		int middleNumber = competenceRepo.findAll().size();

		assertEquals(1, middleNumber - startNumber);

		competenceRepo.delete(maCompetence);

		int finalNumber = competenceRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

	@Test
	public void testCompetenceQuery() {

		Personne personne = new Personne();
		personne.setNom("personnenomcompetenceQuery");
		personne.setPrenom("personnePrenomCompetenceQuery");
		personne = personneRepo.save(personne);

		Entreprise monEntreprise = new Entreprise();
		monEntreprise.setNom("entrepriseCompetenceQuery");
		monEntreprise.setNumeroSiret("cdc32654");
		monEntreprise.setTypeContrat("contratCompetenceQuery");
		monEntreprise = entrepriseRepo.save(monEntreprise);

		Competence maCompetence = new Competence();
		maCompetence.setDescription("intitulecompetencequery");
		maCompetence.setIntitule("intitulecompetencequery");
		maCompetence.setPonderation(Ponderation.DIX);
		maCompetence.setEntreprise(monEntreprise);
		maCompetence = competenceRepo.save(maCompetence);

		CompetenceSkeelz competenceSkeelz = new CompetenceSkeelz();
		competenceSkeelz.setCompetence(maCompetence);
		competenceSkeelz = competenceSkeelzRepo.save(competenceSkeelz);

		BilanCompetence bilanCompetence = new BilanCompetence();
		bilanCompetence.setPersonne(personne);
		bilanCompetence.setCompetenceSkeelz(competenceSkeelz);
		bilanCompetence = bilanCompetenceRepo.save(bilanCompetence);

		assertEquals("intitulecompetencequery",
				competenceRepo.findCompetenceByIdEntreprise(monEntreprise.getId()).get(0).getIntitule());
		assertEquals("intitulecompetencequery",
				competenceRepo.findCompetenceByIdEntreprise(monEntreprise.getId()).get(0).getDescription());
		assertEquals(Ponderation.DIX,
				competenceRepo.findCompetenceByIdEntreprise(monEntreprise.getId()).get(0).getPonderation());

		assertEquals("intitulecompetencequery",
				competenceRepo.findCompetenceByIdPersonne(personne.getId()).get(0).getIntitule());
		assertEquals("intitulecompetencequery",
				competenceRepo.findCompetenceByIdPersonne(personne.getId()).get(0).getDescription());
		assertEquals(Ponderation.DIX,
				competenceRepo.findCompetenceByIdPersonne(personne.getId()).get(0).getPonderation());

	}

	@Test
	public void testCompetenceController() {

		int startNumber = competenceCont.list().size();

		Personne personne = new Personne();
		personne.setNom("personnenomcompetenceQuery");
		personne.setPrenom("personnePrenomCompetenceQuery");
		personne = personneRepo.save(personne);

		Cours cours = new Cours();
		cours.setDescription("coursCompetenceController");
		cours.setDifficulte(Difficulte.FACILE);
		cours.setDuree(2);
		cours.setEtat(Etat.OUVERT);
		cours.setIntitule("coursCompetenceController");
		cours = coursRepo.save(cours);

		Competence maCompetence = new Competence();
		maCompetence.setDescription("intitulecompetencecont");
		maCompetence.setIntitule("intitulecompetencecont");
		maCompetence.setPonderation(Ponderation.DIX);

		maCompetence = competenceCont.create(maCompetence);
		maCompetence = competenceCont.update(maCompetence, maCompetence.getId());

		CompetenceSkeelz competenceSkeelz = new CompetenceSkeelz();
		competenceSkeelz.setCompetence(maCompetence);
		competenceSkeelz = competenceSkeelzRepo.save(competenceSkeelz);

		BilanCompetence bilanCompetence = new BilanCompetence();
		bilanCompetence.setPersonne(personne);
		bilanCompetence.setCompetenceSkeelz(competenceSkeelz);
		bilanCompetence = bilanCompetenceRepo.save(bilanCompetence);

		CoursCompetence coursCompetence = new CoursCompetence();
		coursCompetence.setCompetence(maCompetence);
		coursCompetence.setCours(cours);
		coursCompetence.setRelationCours(RelationCours.VALIDE);
		coursCompetence = coursCompetenceRepo.save(coursCompetence);

		assertEquals("intitulecompetencecont", competenceCont.find(maCompetence.getId()).getIntitule());
		assertEquals("intitulecompetencecont", competenceCont.find(maCompetence.getId()).getDescription());
		assertEquals(Ponderation.DIX, competenceCont.find(maCompetence.getId()).getPonderation());

		assertEquals("coursCompetenceController",
				competenceCont.findByCompetenceAndRelationCours(maCompetence.getId(), "VALIDE").get(0).getIntitule());

		assertEquals("personnenomcompetenceQuery",
				competenceCont.findByCompetence(maCompetence.getId()).get(0).getNom());

		int middleNumber = competenceCont.list().size();

		assertEquals(1, middleNumber - startNumber);
	}

	@Test
	public void testCompetenceControllerBis() {
		Competence maCompetence = new Competence();
		maCompetence.setDescription("intitulecompetencequery");
		maCompetence.setIntitule("intitulecompetencequery");
		maCompetence.setPonderation(Ponderation.DIX);
		maCompetence = competenceRepo.save(maCompetence);

		competenceCont.delete(maCompetence.getId());
	}

}
