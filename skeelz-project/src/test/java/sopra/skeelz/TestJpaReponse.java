package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Reponse;
import sopra.skeelz.repository.IReponseRepository;
import sopra.skeelz.web.ReponseController;

@SpringBootTest
public class TestJpaReponse {

	@Autowired
	private IReponseRepository reponseRepo;
	@Autowired
	private ReponseController reponseCont;

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
	
	@Test
	public void testReponseCont() {

		int startNumber = reponseCont.list().size();

		Reponse reponse1 = new Reponse();
		reponse1.setEnonce("testReponseCont");
		reponse1.setJuste(true);
		reponse1 = reponseCont.create(reponse1);
		reponse1 = reponseCont.update(reponse1, reponse1.getId());



		assertEquals("testReponseCont", reponseCont.find(reponse1.getId()).getEnonce());

		int middleNumber = reponseCont.list().size();
		assertEquals(1, (middleNumber - startNumber));

		reponseCont.delete(reponse1.getId());

		int finalNumber = reponseCont.list().size();

		assertEquals(0, finalNumber - startNumber);

	}

}
