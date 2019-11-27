package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Chapitre;
import sopra.skeelz.repository.IChapitreRepository;

@SpringBootTest
public class TestJpaChapitre {

	@Autowired
	private IChapitreRepository Chapitrerepo;

	@Test
	public void testChapitre() {

		int startNumber = Chapitrerepo.findAll().size();

		Chapitre chapitre1 = new Chapitre();

		chapitre1.setTitre("Chapitre 1 test");
		chapitre1.setAgencement(2);

		chapitre1 = Chapitrerepo.save(chapitre1);

		Optional<Chapitre> Chapitre1Find = Chapitrerepo.findById(chapitre1.getId());

		assertEquals("Chapitre 1 test", Chapitre1Find.get().getTitre());

		int middleNumber = Chapitrerepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		Chapitrerepo.delete(chapitre1);

		int finalNumber = Chapitrerepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

}
