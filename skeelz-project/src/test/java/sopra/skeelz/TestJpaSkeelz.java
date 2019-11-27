package sopra.skeelz;


import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.ISkeelzRepository;
import skeelz.modele.Skeelz;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/application-context.xml")
public class TestJpaSkeelz {

	@Autowired
	private ISkeelzRepository skeelzRepo;
	
	@Test
	public void testSkeelz() {
		
		int startNumber = skeelzRepo.findAll().size();
		
		Skeelz skeelz1 = new Skeelz ();
		
		skeelz1.setIntitule("Skeelz 1 test");

		
		
		skeelz1 = skeelzRepo.save(skeelz1);
		
		
		
		Optional<Skeelz> skeelz1Find = skeelzRepo.findById(skeelz1.getId());
		
		Assert.assertEquals("Skeelz 1 test", skeelz1Find.get().getIntitule());

		
		int middleNumber = skeelzRepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		skeelzRepo.delete(skeelz1);
		
		int finalNumber = skeelzRepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
		
	}

}
