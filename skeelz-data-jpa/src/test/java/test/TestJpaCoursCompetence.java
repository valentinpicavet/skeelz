package test;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.ICoursCompetenceRepository;
import skeelz.modele.CoursCompetence;
import skeelz.modele.RelationCours;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class TestJpaCoursCompetence {

	@Autowired
	private ICoursCompetenceRepository coursCompetenceRepo;

	@Test
	public void testCoursCompetence() {

		int startNumber = coursCompetenceRepo.findAll().size();

		CoursCompetence monCoursComp = new CoursCompetence();

		monCoursComp.setRelationCours(RelationCours.VALIDE);
		;

		monCoursComp = coursCompetenceRepo.save(monCoursComp);

		Optional<CoursCompetence> monCoursCompFind = coursCompetenceRepo.findById(monCoursComp.getId());

		Assert.assertEquals(RelationCours.VALIDE, monCoursCompFind.get().getRelationCours());

		int middleNumber = coursCompetenceRepo.findAll().size();

		Assert.assertEquals(1, (middleNumber - startNumber));

		coursCompetenceRepo.delete(monCoursComp);

		int finalNumber = coursCompetenceRepo.findAll().size();

		Assert.assertEquals(0, finalNumber - startNumber);
	}

}
