package sopra.skeelz;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Chapitre;
import sopra.skeelz.model.ElementDeCours;
import sopra.skeelz.model.Paragraphe;
import sopra.skeelz.repository.IChapitreRepository;
import sopra.skeelz.repository.IElementDeCoursRepository;
import sopra.skeelz.web.ElementDeCoursController;


@SpringBootTest
public class TestJpaElementDeCours {

	@Autowired
	private IElementDeCoursRepository elementDeCoursRepo;
	@Autowired
	private ElementDeCoursController elementDeCoursCont;
	@Autowired
	private IChapitreRepository chapitreRepo;
	
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
	
	@Test
	public void testElementDeCoursQuery() {
		
		Chapitre chapitre = new Chapitre();
		chapitre.setAgencement(7);
		chapitre.setTitre("titreElementDeCoursQuery");
		chapitre = chapitreRepo.save(chapitre);
			
		ElementDeCours chap1par1 = new Paragraphe();
		chap1par1.setAgencement(0);
		((Paragraphe) chap1par1).setTexte("paragraphe 1 test");	
		chap1par1.setChapitre(chapitre);
		chap1par1 = elementDeCoursRepo.save(chap1par1);
		
		
		assertEquals("paragraphe 1 test", ((Paragraphe)elementDeCoursRepo.findElementDeCours(chapitre.getId()).get(0)).getTexte());
		assertEquals("paragraphe 1 test", ((Paragraphe)elementDeCoursRepo.findElementDeCoursByChapitreAndAgencement(chapitre.getId(), 0)).getTexte());
				
	}
	
	@Test
	public void testElementDeCoursCont() {
		
		int startNumber = elementDeCoursCont.list().size();
		
		Chapitre chapitre = new Chapitre();
		chapitre.setAgencement(7);
		chapitre.setTitre("titreElementDeCoursCont");
		chapitre = chapitreRepo.save(chapitre);
		
		ElementDeCours chap1par1 = new Paragraphe();
		chap1par1.setAgencement(0);
		chap1par1.setChapitre(chapitre);
		((Paragraphe) chap1par1).setTexte("paragraphe 1 test");	
		chap1par1 = elementDeCoursCont.create(chap1par1);
		chap1par1 = elementDeCoursCont.update(chap1par1, chap1par1.getId());
		
		
		assertEquals("paragraphe 1 test", (((Paragraphe) elementDeCoursCont.find(chap1par1.getId())).getTexte()));
		assertEquals("paragraphe 1 test", (((Paragraphe) elementDeCoursCont.findElementDeCoursByChapitreAndAgencement(chapitre.getId(), 0)).getTexte()));
		
		int middleNumber = elementDeCoursCont.list().size();
		assertEquals(1, (middleNumber - startNumber));
		
		elementDeCoursCont.delete(chap1par1.getId());
		
		int finalNumber =  elementDeCoursCont.list().size();
		
		assertEquals(0, finalNumber - startNumber);
		
	}

}





