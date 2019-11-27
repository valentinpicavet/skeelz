package sopra.skeelz;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.ElementDeCours;
import sopra.skeelz.model.Paragraphe;
import sopra.skeelz.repository.IElementDeCoursRepository;


@SpringBootTest
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
		
		assertEquals("paragraphe 1 test", ((Paragraphe) chap1par1Find.get()).getTexte());
		
		int middleNumber = elementDeCoursRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));
		
		elementDeCoursRepo.delete(chap1par1);
		
		int finalNumber = elementDeCoursRepo.findAll().size();
		
		assertEquals(0, finalNumber - startNumber);
		
	}

}





