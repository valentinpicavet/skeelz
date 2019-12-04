package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Competence;
import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.web.CompetenceSkeelzController;

@SpringBootTest
public class TestJpaCompetenceSkeelz {

	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;
	@Autowired
	private CompetenceSkeelzController competenceSkeelzCont;

	@Test
	public void testCompetenceSkeelz() {

		int startNumber = competenceSkeelzRepo.findAll().size();

		CompetenceSkeelz compSk = new CompetenceSkeelz();
		Competence maCompetence = new Competence();
		maCompetence.setIntitule("java");
		maCompetence.setPonderation(Ponderation.DIX);

		maCompetence = competenceRepo.save(maCompetence);
		compSk.setCompetence(maCompetence);

		compSk = competenceSkeelzRepo.save(compSk);

		Optional<CompetenceSkeelz> compSkFind = competenceSkeelzRepo.findById(compSk.getId());
		assertEquals("java", compSkFind.get().getCompetence().getIntitule());

		int middleNumber = competenceSkeelzRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		competenceSkeelzRepo.delete(compSk);

		int finalNumber = competenceSkeelzRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

	@Test
	public void testCompetenceSkeelzController() {

		int startNumber = competenceSkeelzCont.list().size();

		CompetenceSkeelz compSk = new CompetenceSkeelz();
		Competence maCompetence = new Competence();
		maCompetence.setIntitule("compSkeelzCont");
		maCompetence.setPonderation(Ponderation.DIX);

		maCompetence = competenceRepo.save(maCompetence);
		compSk.setCompetence(maCompetence);

		compSk = competenceSkeelzCont.create(compSk);
		compSk = competenceSkeelzCont.update(compSk, compSk.getId());

		assertEquals("compSkeelzCont", competenceSkeelzCont.find(compSk.getId()).getCompetence().getIntitule());

		int middleNumber = competenceSkeelzCont.list().size();
		assertEquals(1, (middleNumber - startNumber));

		competenceSkeelzCont.delete(compSk.getId());

		int finalNumber = competenceSkeelzCont.list().size();

		assertEquals(0, finalNumber - startNumber);

	}

}
