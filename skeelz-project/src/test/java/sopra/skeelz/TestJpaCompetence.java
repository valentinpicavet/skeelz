package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Competence;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.repository.ICompetenceRepository;

@SpringBootTest
public class TestJpaCompetence {

	@Autowired
	private ICompetenceRepository competenceRepo;

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

}
