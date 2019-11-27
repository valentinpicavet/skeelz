package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Competence;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.repository.IBilanCompetenceRepository;
import sopra.skeelz.repository.ICompetenceRepository;

@SpringBootTest
public class TestJpaBilanCompetence {

	@Autowired
	private IBilanCompetenceRepository bilanCompetenceRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;

	@Test
	public void testBilanCompetence() {

		int startNumber = bilanCompetenceRepo.findAll().size();

		BilanCompetence monBilan = new BilanCompetence();
		Competence maCompetence = new Competence();
		maCompetence.setIntitule("java");
		maCompetence.setPonderation(Ponderation.DIX);
		
		maCompetence = competenceRepo.save(maCompetence);
		
		monBilan.setCompetence(maCompetence);

		monBilan = bilanCompetenceRepo.save(monBilan);
		

		Optional<BilanCompetence> monBilanFind = bilanCompetenceRepo.findById(monBilan.getId());
		assertEquals("java", monBilanFind.get().getCompetence().getIntitule());
		

		int middleNumber = bilanCompetenceRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		bilanCompetenceRepo.delete(monBilan);
		int finalNumber = bilanCompetenceRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);
	}

}
