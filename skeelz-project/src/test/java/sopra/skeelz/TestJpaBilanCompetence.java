package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Competence;
import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.repository.IBilanCompetenceRepository;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.web.BilanCompetenceController;

@SpringBootTest
public class TestJpaBilanCompetence {

	@Autowired
	private IBilanCompetenceRepository bilanCompetenceRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;
	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private BilanCompetenceController bilanCompetencecontroller;

	@Test
	public void testBilanCompetence() {

		int startNumber = bilanCompetenceRepo.findAll().size();

		BilanCompetence monBilan = new BilanCompetence();
		Competence maCompetence = new Competence();
		maCompetence.setIntitule("ma competence test jpa");
		maCompetence.setPonderation(Ponderation.DIX);

		maCompetence = competenceRepo.save(maCompetence);

		CompetenceSkeelz maCompetenceSkeelz = new CompetenceSkeelz();
		maCompetenceSkeelz.setCompetence(maCompetence);
		maCompetenceSkeelz = competenceSkeelzRepo.save(maCompetenceSkeelz);
		monBilan.setCompetenceSkeelz(maCompetenceSkeelz);

		monBilan = bilanCompetenceRepo.save(monBilan);

		Optional<BilanCompetence> monBilanFind = bilanCompetenceRepo.findById(monBilan.getId());
		assertEquals("ma competence test jpa", monBilanFind.get().getCompetenceSkeelz().getCompetence().getIntitule());

		int middleNumber = bilanCompetenceRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		bilanCompetenceRepo.delete(monBilan);
		int finalNumber = bilanCompetenceRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);
	}

	@Test
	public void testBilanCompetenceQuery() {

		Personne maPersonne = new Personne();
		maPersonne.setNom("JEAN");
		maPersonne.setPrenom("Paul");
		maPersonne.setTelephone("026134515");
		maPersonne.setNoteGlobal(23);
		maPersonne = personneRepo.save(maPersonne);

		Competence maCompetence = new Competence();
		maCompetence.setIntitule("ma competence test query");
		maCompetence.setPonderation(Ponderation.DIX);
		maCompetence = competenceRepo.save(maCompetence);

		CompetenceSkeelz maCompetenceSkeelz = new CompetenceSkeelz();
		maCompetenceSkeelz.setCompetence(maCompetence);
		maCompetenceSkeelz = competenceSkeelzRepo.save(maCompetenceSkeelz);

		BilanCompetence monBilan = new BilanCompetence();
		monBilan.setCompetenceSkeelz(maCompetenceSkeelz);
		monBilan.setPersonne(maPersonne);
		monBilan = bilanCompetenceRepo.save(monBilan);

		assertEquals("JEAN", bilanCompetenceRepo.findByPersonne(maPersonne).get(0).getPersonne().getNom());

	}

	@Test
	public void testBilanCompetenceController() {

		int startNumber = bilanCompetencecontroller.list().size();

		BilanCompetence monBilan = new BilanCompetence();
		Competence maCompetence = new Competence();
		maCompetence.setIntitule("ma competence test controller");
		maCompetence.setPonderation(Ponderation.DIX);

		maCompetence = competenceRepo.save(maCompetence);

		CompetenceSkeelz maCompetenceSkeelz = new CompetenceSkeelz();
		maCompetenceSkeelz.setCompetence(maCompetence);
		maCompetenceSkeelz = competenceSkeelzRepo.save(maCompetenceSkeelz);
		monBilan.setCompetenceSkeelz(maCompetenceSkeelz);

		monBilan = bilanCompetencecontroller.create(monBilan);
		monBilan = bilanCompetencecontroller.update(monBilan, monBilan.getId());

		assertEquals("ma competence test controller",
				bilanCompetencecontroller.find(monBilan.getId()).getCompetenceSkeelz().getCompetence().getIntitule());

		int middleNumber = bilanCompetenceRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		bilanCompetencecontroller.delete(monBilan.getId());
		int finalNumber = bilanCompetencecontroller.list().size();

		assertEquals(0, finalNumber - startNumber);

	}
}
