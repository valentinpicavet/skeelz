package test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IChapitreRepository;
import skeelz.modele.Chapitre;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/application-context.xml")
public class TestJpaChapitre {
	
	
	@Autowired
	private IChapitreRepository Chapitrerepo;
	
	
	@Test
	public void testChapitre() {
		
int startNumber = Chapitrerepo.findAll().size();
		
		Chapitre chapitre1 = new Chapitre ();
		
		chapitre1.setTitre("Chapitre 1 test");
		chapitre1.setAgencement(2);
		
	

		
		
		chapitre1 = Chapitrerepo.save(chapitre1);
		
		
		
		Optional<Chapitre> Chapitre1Find = Chapitrerepo.findById(chapitre1.getId());
		
		Assert.assertEquals("Chapitre 1 test", Chapitre1Find.get().getTitre());

		
		int middleNumber = Chapitrerepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		Chapitrerepo.delete(chapitre1);
		
		int finalNumber = Chapitrerepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
		
	
	}

}
