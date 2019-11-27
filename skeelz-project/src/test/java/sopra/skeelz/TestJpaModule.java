package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Module;
import sopra.skeelz.repository.IModuleRepository;

@SpringBootTest
public class TestJpaModule {

	@Autowired
	private IModuleRepository Modulerepo;

	@Test
	public void testModule() {

		int startNumber = Modulerepo.findAll().size();

		Module module1 = new Module();

		module1.setIntitule("Module 1 test");
		module1.setAgencement(1);
		module1.setEnonceQCM("Enonce QCM test");
		module1.setPeriodicite(5);
		module1.setNbTentativeAutorise(4);

		module1 = Modulerepo.save(module1);

		Optional<Module> module1Find = Modulerepo.findById(module1.getId());

		assertEquals("Module 1 test", module1Find.get().getIntitule());
		assertEquals(1, module1Find.get().getAgencement());
		assertEquals("Enonce QCM test", module1Find.get().getEnonceQCM());
		assertEquals(5, module1Find.get().getPeriodicite());
		assertEquals(4, module1Find.get().getNbTentativeAutorise());

		int middleNumber = Modulerepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		Modulerepo.delete(module1);

		int finalNumber = Modulerepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

}
