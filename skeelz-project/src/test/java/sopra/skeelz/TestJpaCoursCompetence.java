package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.CoursCompetence;
import sopra.skeelz.model.RelationCours;
import sopra.skeelz.repository.ICoursCompetenceRepository;

@SpringBootTest
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

		assertEquals(RelationCours.VALIDE, monCoursCompFind.get().getRelationCours());

		int middleNumber = coursCompetenceRepo.findAll().size();

		assertEquals(1, (middleNumber - startNumber));

		coursCompetenceRepo.delete(monCoursComp);

		int finalNumber = coursCompetenceRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);
	}

}
