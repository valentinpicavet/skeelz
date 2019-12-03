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
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.repository.IBilanCompetenceRepository;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.repository.ICoursPersonneRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.ISkeelzRepository;
import sopra.skeelz.web.PersonneController;

@SpringBootTest
public class TestJpaPersonne {

	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;
	@Autowired
	private ISkeelzRepository skeelzRepo;
	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private ICoursPersonneRepository coursPersonneRepo;
	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;
	@Autowired
	private IBilanCompetenceRepository bilanCompetenceRepo;
	@Autowired
	private PersonneController personneCont;

	@Test
	public void testPersonne() {

		int startNumber = personneRepo.findAll().size();

		Personne maPersonne = new Personne();
		maPersonne.setNom("JEAN");
		maPersonne.setPrenom("Paul");
		maPersonne.setTelephone("026134515");
		maPersonne.setNoteGlobal(23);

		maPersonne = personneRepo.save(maPersonne);

		Optional<Personne> maPersonneFind = personneRepo.findById(maPersonne.getId());

		assertEquals("JEAN", maPersonneFind.get().getNom());
		assertEquals("Paul", maPersonneFind.get().getPrenom());
		assertEquals("026134515", maPersonneFind.get().getTelephone());
		assertEquals(23, maPersonneFind.get().getNoteGlobal());

		int middleNumber = personneRepo.findAll().size();

		assertEquals(1, (middleNumber - startNumber));

		personneRepo.delete(maPersonne);

		int finalNumber = personneRepo.findAll().size();

		assertEquals(0, (finalNumber - startNumber));

	}

	@Test
	public void testPersonneQuery() {

		Competence competence = new Competence();
		competence.setIntitule("PersonneQuery");
		competence.setPonderation(Ponderation.CINQ);
		competence.setDescription("PersonneQuery");
		competence = competenceRepo.save(competence);

		Skeelz skeelz = new Skeelz();
		skeelz.setIntitule("PersonneQuery");
		skeelz = skeelzRepo.save(skeelz);

		CompetenceSkeelz competenceSkeelz = new CompetenceSkeelz();
		competenceSkeelz.setCompetence(competence);
		competenceSkeelz.setSkeelz(skeelz);
		competenceSkeelz = competenceSkeelzRepo.save(competenceSkeelz);

		Personne maPersonne = new Personne();
		maPersonne.setNom("PersonneQuery");
		maPersonne.setPrenom("PersonneQuery");
		maPersonne.setTelephone("026134515");
		maPersonne.setNoteGlobal(23);
		maPersonne = personneRepo.save(maPersonne);

		BilanCompetence bilanCompetence = new BilanCompetence();
		bilanCompetence.setCompetenceSkeelz(competenceSkeelz);
		bilanCompetence.setPersonne(maPersonne);
		bilanCompetence = bilanCompetenceRepo.save(bilanCompetence);

		assertEquals("PersonneQuery", personneRepo.findPersonneBySkeelz(skeelz.getId()).get(0).getNom());
		assertEquals("PersonneQuery", personneRepo.findPersonneByIdCompetence(competence.getId()).get(0).getNom());

	}

	@Test
	public void testPersonneCont() {

		int startNumber = personneCont.list().size();

		Competence competence = new Competence();
		competence.setIntitule("CompPersonneCOnt");
		competence.setPonderation(Ponderation.CINQ);
		competence.setDescription("PersonneCont");
		competence = competenceRepo.save(competence);

		Skeelz skeelz = new Skeelz();
		skeelz.setIntitule("SkeelzPersonneCont");
		skeelz = skeelzRepo.save(skeelz);

		CompetenceSkeelz competenceSkeelz = new CompetenceSkeelz();
		competenceSkeelz.setCompetence(competence);
		competenceSkeelz.setSkeelz(skeelz);
		competenceSkeelz = competenceSkeelzRepo.save(competenceSkeelz);

		Personne maPersonne = new Personne();
		maPersonne.setNom("personneCont");
		maPersonne.setPrenom("personneCont");
		maPersonne.setTelephone("026134515");
		maPersonne.setNoteGlobal(23);
		maPersonne = personneCont.create(maPersonne);
		maPersonne = personneCont.update(maPersonne, maPersonne.getId());

		BilanCompetence bilanCompetence = new BilanCompetence();
		bilanCompetence.setCompetenceSkeelz(competenceSkeelz);
		bilanCompetence.setPersonne(maPersonne);
		bilanCompetence = bilanCompetenceRepo.save(bilanCompetence);

		Cours cours1 = new Cours();
		cours1.setIntitule("CourspersonneCont");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("chemin");
		cours1.setDescription("personneCont");
		cours1 = coursRepo.save(cours1);

		CoursPersonne coursPersonne = new CoursPersonne();
		coursPersonne.setCours(cours1);
		coursPersonne.setPersonne(maPersonne);
		coursPersonne.setEtatCours(EtatCours.VALIDE);
		coursPersonne = coursPersonneRepo.save(coursPersonne);

		assertEquals("personneCont", personneCont.find(maPersonne.getId()).getNom());
		assertEquals("CourspersonneCont", personneCont.findCours(maPersonne.getId()).get(0).getIntitule());
		assertEquals("SkeelzPersonneCont", personneCont.findSkeelz(maPersonne.getId()).get(0).getIntitule());
		assertEquals("CompPersonneCOnt", personneCont.findCompetence(maPersonne.getId()).get(0).getIntitule());

		int middleNumber = personneCont.list().size();

		assertEquals(1, (middleNumber - startNumber));

	}

	@Test
	public void testPersonneContBis() {
		Personne maPersonne = new Personne();
		maPersonne.setNom("personneCont");
		maPersonne.setPrenom("personneCont");
		maPersonne.setTelephone("026134515");
		maPersonne.setNoteGlobal(23);
		maPersonne = personneCont.create(maPersonne);
		personneCont.delete(maPersonne.getId());
	}

}
