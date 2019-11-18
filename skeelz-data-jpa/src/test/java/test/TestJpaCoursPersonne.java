package test;


import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.ICoursPersonneRepository;

import skeelz.modele.CoursPersonne;
import skeelz.modele.EtatCours;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/application-context.xml")
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
		
		Assert.assertEquals(EtatCours.VALIDE , coursPersonne1Find.get().getEtatCours());
		
		int middleNumber = CoursPersonneRepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		CoursPersonneRepo.delete(coursPersonne1);
		
		int finalNumber = CoursPersonneRepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
		
	}

}




