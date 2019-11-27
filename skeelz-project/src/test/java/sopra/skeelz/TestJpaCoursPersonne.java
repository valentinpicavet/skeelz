package sopra.skeelz;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.repository.ICoursPersonneRepository;


@SpringBootTest
public class TestJpaCoursPersonne {

	@Autowired
	private ICoursPersonneRepository CoursPersonneRepo;
	
	@Test
	public void testCoursPersonne() {
		
		int startNumber = CoursPersonneRepo.findAll().size();
		
		CoursPersonne coursPersonne1 = new CoursPersonne ();
	

		coursPersonne1.setEtatCours(EtatCours.VALIDE);
			
		coursPersonne1 = CoursPersonneRepo.save(coursPersonne1);
				
		Optional<CoursPersonne> coursPersonne1Find = CoursPersonneRepo.findById(coursPersonne1.getId());
		
		assertEquals(EtatCours.VALIDE , coursPersonne1Find.get().getEtatCours());
		
		int middleNumber = CoursPersonneRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));
		
		CoursPersonneRepo.delete(coursPersonne1);
		
		int finalNumber = CoursPersonneRepo.findAll().size();
		
		assertEquals(0, finalNumber - startNumber);
		
	}

}




