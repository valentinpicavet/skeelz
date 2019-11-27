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

@SpringBootTest
public class TestJpaCompetenceSkeelz {

	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;
	
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

}
