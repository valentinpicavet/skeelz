package test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IModuleRepository;
import skeelz.modele.Module;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/application-context.xml")
public class TestJpaModule {
	
	
	@Autowired
	private IModuleRepository Modulerepo;
	
	
	@Test
	public void testModule() {
		
int startNumber = Modulerepo.findAll().size();
		
		Module module1 = new Module ();
		
		module1.setIntitule("Module 1 test");
		module1.setAgencement(1);
		module1.setEnonceQCM("Enonce QCM test");
		module1.setPeriodicite(5);
		module1.setNbTentativeAutorise(4);
	

		
		
		module1 = Modulerepo.save(module1);
		
		
		
		Optional<Module> module1Find = Modulerepo.findById(module1.getId());
		
		Assert.assertEquals("Module 1 test", module1Find.get().getIntitule());
		Assert.assertEquals(1, module1Find.get().getAgencement());
		Assert.assertEquals("Enonce QCM test", module1Find.get().getEnonceQCM());
		Assert.assertEquals(5, module1Find.get().getPeriodicite());
		Assert.assertEquals(4, module1Find.get().getNbTentativeAutorise());
		
		
		int middleNumber = Modulerepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		Modulerepo.delete(module1);
		
		int finalNumber = Modulerepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
		
	
	}

}
