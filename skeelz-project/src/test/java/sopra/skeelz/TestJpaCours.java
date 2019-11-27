package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Cours;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Etat;
import sopra.skeelz.repository.ICoursRepository;

@SpringBootTest
public class TestJpaCours {

	@Autowired
	private ICoursRepository coursRepo;

	@Test
	public void testCours() {

		int startNumber = coursRepo.findAll().size();

		Cours cours1 = new Cours();

		cours1.setIntitule("java debutant");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("chemin");
		cours1.setDescription("description");

		cours1 = coursRepo.save(cours1);

		Optional<Cours> cours1Find = coursRepo.findById(cours1.getId());

		assertEquals("java debutant", cours1Find.get().getIntitule());
		assertEquals(Difficulte.FACILE, cours1Find.get().getDifficulte());


		int middleNumber = coursRepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		coursRepo.delete(cours1);

		int finalNumber = coursRepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

}
