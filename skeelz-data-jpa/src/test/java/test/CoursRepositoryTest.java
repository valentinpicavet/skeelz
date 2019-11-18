package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import repository.ICoursRepository;
import repository.IUtilisateurRepository;
import skeelz.modele.Cours;
import skeelz.modele.Difficulte;
import skeelz.modele.Etat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")

public class CoursRepositoryTest {
	
	@Autowired
	private ICoursRepository coursRepo;
	
	@Test
	public void testUtilisateur() {
		
		int startNumber = coursRepo.findAll().size();
		
		Cours cours1 = new Cours ();
		cours1.setIntitule("java debutant");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("chemin");
		cours1.setDescription("description");
		
		
		
		cours1 = coursRepo.save(cours1);
				
		cours1 = coursRepo.findById(cours1.getId());
		
		System.out.println(cours1.getIntitule());
		System.out.println(cours1.getDifficulte());
		
		int middleNumber = coursRepo.findAll().size();
		System.out.println(middleNumber - startNumber);
		
		coursRepo.delete(cours1);
		
	}

}
