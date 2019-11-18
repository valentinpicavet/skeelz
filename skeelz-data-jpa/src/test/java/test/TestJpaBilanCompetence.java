package test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IBilanCompetenceRepository;
import repository.ICompetenceRepository;
import skeelz.modele.BilanCompetence;
import skeelz.modele.Competence;
import skeelz.modele.Ponderation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
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
		Assert.assertEquals("java", monBilanFind.get().getCompetence().getIntitule());
		

		int middleNumber = bilanCompetenceRepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));

		bilanCompetenceRepo.delete(monBilan);
		int finalNumber = bilanCompetenceRepo.findAll().size();

		Assert.assertEquals(0, finalNumber - startNumber);
	}

}
