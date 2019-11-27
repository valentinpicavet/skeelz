package sopra.skeelz;


import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IReponseRepository;

import skeelz.modele.Reponse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/application-context.xml")
public class TestJpaReponse {

	@Autowired
	private IReponseRepository reponseRepo;
	
	@Test
	public void testReponse() {
		
		int startNumber = reponseRepo.findAll().size();
		
		Reponse reponse1 = new Reponse ();
	

		reponse1.setEnonce("Reponse 1 test");
		reponse1.setJuste(true);
		
		

		
		
		reponse1 = reponseRepo.save(reponse1);
		
		
		
		Optional<Reponse> reponse1Find = reponseRepo.findById(reponse1.getId());
		
		Assert.assertEquals("Reponse 1 test", reponse1Find.get().getEnonce());
		Assert.assertEquals(true, reponse1Find.get().isJuste());
		
		int middleNumber = reponseRepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		reponseRepo.delete(reponse1);
		
		int finalNumber = reponseRepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
		
	}

}



