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
	private IElementDeCoursRepository elementDeCoursRepo;
	
	@Test
	public void testElementDeCours() {
		
		int startNumber = elementDeCoursRepo.findAll().size();
		
		ElementDeCours chap1par1 = new Paragraphe();
		chap1par1.setAgencement(0);
		((Paragraphe) chap1par1).setTexte("paragraphe 1 test");	
		chap1par1 = elementDeCoursRepo.save(chap1par1);
		
		Optional<ElementDeCours> chap1par1Find = elementDeCoursRepo.findById(chap1par1.getId());
		
		Assert.assertEquals("paragraphe 1 test", ((Paragraphe) chap1par1Find.get()).getTexte());
		
		int middleNumber = elementDeCoursRepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		elementDeCoursRepo.delete(chap1par1);
		
		int finalNumber = elementDeCoursRepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
		
	}

}





