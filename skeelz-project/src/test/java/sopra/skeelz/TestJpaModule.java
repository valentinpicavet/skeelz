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
import sopra.skeelz.model.Question;
import sopra.skeelz.model.Reponse;
import sopra.skeelz.repository.IChapitreRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IModuleRepository;
import sopra.skeelz.repository.IQuestionRepository;
import sopra.skeelz.repository.IReponseRepository;
import sopra.skeelz.web.ModuleController;

@SpringBootTest
public class TestJpaModule {

	@Autowired
	private IModuleRepository Modulerepo;
	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private IChapitreRepository chapitreRepo;
	@Autowired
	private IQuestionRepository questionRepo;
	@Autowired
	private IReponseRepository reponseRepo;
	@Autowired
	private ModuleController moduleCont;

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

	@Test
	public void testModuleQuery() {

		Cours cours1 = new Cours();
		cours1.setIntitule("intituleModuleQuery");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("chemin");
		cours1.setDescription("descriptionModuleQuery");
		cours1 = coursRepo.save(cours1);

		Module module1 = new Module();
		module1.setIntitule("ModuleQuery");
		module1.setAgencement(1);
		module1.setEnonceQCM("ModuleQuery");
		module1.setPeriodicite(5);
		module1.setCours(cours1);
		module1.setNbTentativeAutorise(4);
		module1 = Modulerepo.save(module1);

		Chapitre chapitre = new Chapitre();
		chapitre.setModule(module1);
		chapitre.setAgencement(6);
		chapitre.setTitre("ModuleQuery");
		chapitre = chapitreRepo.save(chapitre);

		assertEquals("ModuleQuery", Modulerepo.findModule(cours1.getId()).get(0).getIntitule());
		assertEquals("ModuleQuery",
				Modulerepo.findModulesWithChapitres(cours1.getId()).get(0).getChapitres().get(0).getTitre());
		assertEquals("ModuleQuery", Modulerepo.findModuleByCoursAndAgencement(cours1.getId(), 1).getIntitule());

	}

	@Test
	public void testModuleCont() {

		int startNumber = moduleCont.list().size();
		
		Cours cours1 = new Cours();
		cours1.setIntitule("intituleModuleCont");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setCheminImageCours("chemin");
		cours1.setDescription("descriptionModuleCont");
		cours1 = coursRepo.save(cours1);


		Module module1 = new Module();
		module1.setIntitule("testModuleCont");
		module1.setAgencement(1);
		module1.setCours(cours1);
		module1.setEnonceQCM("testModuleCont");
		module1.setPeriodicite(5);
		module1.setNbTentativeAutorise(4);
		module1 = moduleCont.create(module1);
		module1 = moduleCont.update(module1, module1.getId());
		
		Question question = new Question();
		question.setModule(module1);
		question.setQuestion("questionModuleCont");
		question = questionRepo.save(question);
		
		Reponse reponse = new Reponse();
		reponse.setEnonce("enonceModuleCOnt");
		reponse.setJuste(true);
		reponse.setQuestion(question);
		reponse = reponseRepo.save(reponse);
		
		Chapitre chapitre = new Chapitre();
		chapitre.setModule(module1);
		chapitre.setAgencement(6);
		chapitre.setTitre("ModuleQuery");
		chapitre = chapitreRepo.save(chapitre);

		assertEquals("testModuleCont", moduleCont.find(module1.getId()).getIntitule());
		assertEquals("testModuleCont", moduleCont.findModuleByCoursAndAgencement(cours1.getId(),1).getIntitule());
		assertEquals("ModuleQuery", moduleCont.findChapitre(module1.getId()).get(0).getTitre());
		Question question2 = moduleCont.findQuestionAndReponse(module1.getId()).get(0);
		assertEquals("questionModuleCont", question2.getQuestion());
		
		


		int middleNumber = moduleCont.list().size();
		assertEquals(1, (middleNumber - startNumber));

	}
	
	@Test
	public void testModuleContBis() {
		Module module1 = new Module();
		module1.setIntitule("testModuleCont");
		module1.setAgencement(1);
		module1.setEnonceQCM("testModuleCont");
		module1.setPeriodicite(5);
		module1.setNbTentativeAutorise(4);
		module1 = moduleCont.create(module1);
		moduleCont.delete(module1.getId());
	}


}
