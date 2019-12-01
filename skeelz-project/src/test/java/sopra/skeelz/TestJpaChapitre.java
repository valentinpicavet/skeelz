package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Chapitre;
import sopra.skeelz.model.Cours;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.Module;
import sopra.skeelz.model.Paragraphe;
import sopra.skeelz.repository.IChapitreRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IElementDeCoursRepository;
import sopra.skeelz.repository.IModuleRepository;
import sopra.skeelz.web.ChapitreController;

@SpringBootTest
public class TestJpaChapitre {

	@Autowired
	private IChapitreRepository Chapitrerepo;
	@Autowired
	private IModuleRepository moduleRepo;
	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private ChapitreController ChapitreCont;
	@Autowired
	private IElementDeCoursRepository elementDeCoursRepo;


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
	
	@Test
	public void testChapitreRepo() {
		
		Cours cours1 = new Cours();
		cours1.setDuree(2);
		cours1.setEtat(Etat.OUVERT);
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setIntitule("cours chapitre repo");
		cours1.setDescription("cours chapitre repo");
		cours1 = coursRepo.save(cours1);
		
		Module module1 = new Module();
		module1.setIntitule("modulechapitrerepo1");
		module1.setAgencement(0);
		module1.setCours(cours1);
		module1 = moduleRepo.save(module1);
		
		
		Chapitre chapitre1 = new Chapitre();
		chapitre1.setTitre("Chapitre 1 query");
		chapitre1.setAgencement(2);
		chapitre1.setModule(module1);
		chapitre1 = Chapitrerepo.save(chapitre1);

		assertEquals("Chapitre 1 query", Chapitrerepo.findChapitreByModuleId(module1.getId()).get(0).getTitre());

		assertEquals("Chapitre 1 query", Chapitrerepo.findChapitreByModuleAndAgencement(module1.getId(), 2).getTitre());

		assertEquals("Chapitre 1 query", Chapitrerepo.findChapitre(cours1.getId()).get(0).getTitre());

		Chapitrerepo.delete(chapitre1);


	}
	
	@Test
	public void testChapitreController() {

		int startNumber = ChapitreCont.list().size();
		
		Cours cours1 = new Cours();
		cours1.setDuree(2);
		cours1.setEtat(Etat.OUVERT);
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setIntitule("cours chapitre cont");
		cours1.setDescription("cours chapitre cont");
		cours1 = coursRepo.save(cours1);
		
		Module module1 = new Module();
		module1.setIntitule("modulechapitrecont1");
		module1.setAgencement(0);
		module1.setCours(cours1);
		module1 = moduleRepo.save(module1);
		
		
		Chapitre chapitre1 = new Chapitre();
		chapitre1.setTitre("Chapitre 1 cont");
		chapitre1.setAgencement(2);
		chapitre1.setModule(module1);
		chapitre1 = ChapitreCont.create(chapitre1);
		chapitre1 = ChapitreCont.update(chapitre1, chapitre1.getId());
		
		Paragraphe elementdecours1 = new Paragraphe();
		elementdecours1.setTexte("text paragraphe chapitre controller");
		elementdecours1.setAgencement(2);
		elementdecours1.setChapitre(chapitre1);
		elementdecours1 = elementDeCoursRepo.save(elementdecours1);
		

		assertEquals("Chapitre 1 cont", ChapitreCont.findChapitreByModuleAndAgencement(module1.getId(), 2).getTitre());
		
		assertEquals("Chapitre 1 cont", ChapitreCont.find(chapitre1.getId()).getTitre());

		Paragraphe elementdecours2 = (Paragraphe) ChapitreCont.listElementCours(chapitre1.getId()).get(0);
		
		assertEquals("text paragraphe chapitre controller", elementdecours2.getTexte());

		int middleNumber = Chapitrerepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));
		
		elementDeCoursRepo.delete(elementdecours1);

		ChapitreCont.delete(chapitre1.getId());

		int finalNumber = ChapitreCont.list().size();

		assertEquals(0, finalNumber - startNumber);

	}

}
