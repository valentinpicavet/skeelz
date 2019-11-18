package test;


import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IElementDeCoursRepository;

import skeelz.modele.ElementDeCours;
import skeelz.modele.Paragraphe;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/application-context.xml")
public class TestJpaElementDeCours {

	@Autowired
	private IElementDeCoursRepository ElementDeCoursRepo;
	
	@Test
	public void testElementDeCours() {
		
		int startNumber = ElementDeCoursRepo.findAll().size();
		
		Paragraphe paragraphe1 = new Paragraphe();
	
	

		paragraphe1.setTitre("paragraphe 1 test");
		paragraphe1.setAgencement(2);
		paragraphe1.
		
		

		
		
		paragraphe1 = paragrapheRepo.save(paragraphe1);
		
		
		
		Optional<paragraphe> paragraphe1Find = paragrapheRepo.findById(paragraphe1.getId());
		
		Assert.assertEquals("paragraphe 1 test", paragraphe1Find.get().getEnonce());
		Assert.assertEquals(true, paragraphe1Find.get().isJuste());
		
		int middleNumber = paragrapheRepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		paragrapheRepo.delete(paragraphe1);
		
		int finalNumber = paragrapheRepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
		
	}

}





