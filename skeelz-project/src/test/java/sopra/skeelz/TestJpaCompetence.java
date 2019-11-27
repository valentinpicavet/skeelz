package sopra.skeelz;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.ICompetenceRepository;
import skeelz.modele.Competence;
import skeelz.modele.Ponderation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
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

		Assert.assertEquals("java pour les null", maCompetenceFind.get().getIntitule());
		Assert.assertEquals("trop bien", maCompetenceFind.get().getDescription());
		Assert.assertEquals(Ponderation.DIX, maCompetenceFind.get().getPonderation());

		int middleNumber = competenceRepo.findAll().size();

		Assert.assertEquals(1, middleNumber - startNumber);

		competenceRepo.delete(maCompetence);

		int finalNumber = competenceRepo.findAll().size();

		Assert.assertEquals(0, finalNumber - startNumber);

	}

}
