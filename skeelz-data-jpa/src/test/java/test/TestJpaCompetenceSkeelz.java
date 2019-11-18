package test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.ICompetenceRepository;
import repository.ICompetenceSkeelzRepository;
import skeelz.modele.Competence;
import skeelz.modele.CompetenceSkeelz;
import skeelz.modele.Ponderation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
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
		Assert.assertEquals("java", compSkFind.get().getCompetence().getIntitule());
		
		int middleNumber = competenceSkeelzRepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		competenceSkeelzRepo.delete(compSk);
		
		int finalNumber = competenceSkeelzRepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);

	}

}
