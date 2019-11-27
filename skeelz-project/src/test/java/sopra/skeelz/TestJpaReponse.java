package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Reponse;
import sopra.skeelz.repository.IReponseRepository;

@SpringBootTest
public class TestJpaReponse {

	@Autowired
	private IReponseRepository reponseRepo;

	@Test
	public void testReponse() {

		int startNumber = reponseRepo.findAll().size();

		Reponse reponse1 = new Reponse();

		reponse1.setEnonce("Reponse 1 test");
		reponse1.setJuste(true);

		reponse1 = reponseRepo.save(reponse1);

		Optional<Reponse> reponse1Find = reponseRepo.findById(reponse1.getId());

		assertEquals("Reponse 1 test", reponse1Find.get().getEnonce());
		assertEquals(true, reponse1Find.get().isJuste());

		int middleNumber = reponseRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		reponseRepo.delete(reponse1);

		int finalNumber = reponseRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

}
