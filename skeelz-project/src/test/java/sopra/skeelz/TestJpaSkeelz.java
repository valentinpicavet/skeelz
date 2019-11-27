package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Skeelz;
import sopra.skeelz.repository.ISkeelzRepository;

@SpringBootTest
public class TestJpaSkeelz {

	@Autowired
	private ISkeelzRepository skeelzRepo;

	@Test
	public void testSkeelz() {

		int startNumber = skeelzRepo.findAll().size();

		Skeelz skeelz1 = new Skeelz();

		skeelz1.setIntitule("Skeelz 1 test");

		skeelz1 = skeelzRepo.save(skeelz1);

		Optional<Skeelz> skeelz1Find = skeelzRepo.findById(skeelz1.getId());

		assertEquals("Skeelz 1 test", skeelz1Find.get().getIntitule());

		int middleNumber = skeelzRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		skeelzRepo.delete(skeelz1);

		int finalNumber = skeelzRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

}
