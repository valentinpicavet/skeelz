package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Module;
import sopra.skeelz.model.Question;
import sopra.skeelz.model.Reponse;
import sopra.skeelz.repository.IModuleRepository;
import sopra.skeelz.repository.IQuestionRepository;
import sopra.skeelz.repository.IReponseRepository;
import sopra.skeelz.web.QuestionController;

@SpringBootTest
public class TestJpaQuestion {

	@Autowired
	private IQuestionRepository questionrepo;
	@Autowired
	private QuestionController questionCont;
	@Autowired
	private IModuleRepository moduleRepo;
	@Autowired
	private IReponseRepository reponseRepo;

	@Test
	public void testQuestion() {

		int startNumber = questionrepo.findAll().size();

		Question question1 = new Question();

		question1.setQuestion("question 1 test");

		question1 = questionrepo.save(question1);

		Optional<Question> question1Find = questionrepo.findById(question1.getId());

		assertEquals("question 1 test", question1Find.get().getQuestion());

		int middleNumber = questionrepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		questionrepo.delete(question1);

		int finalNumber = questionrepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}

	@Test
	public void testQuestionQuery() {

		Module module1 = new Module();
		module1.setIntitule("testQuestionQuery");
		module1.setAgencement(1);
		module1.setEnonceQCM("testQuestionQuery");
		module1.setPeriodicite(5);
		module1.setNbTentativeAutorise(4);
		module1 = moduleRepo.save(module1);

		Question question = new Question();
		question.setModule(module1);
		question.setQuestion("testQuestionQuery");
		question = questionrepo.save(question);

		Reponse reponse = new Reponse();
		reponse.setEnonce("testQuestionQuery");
		reponse.setJuste(true);
		reponse.setQuestion(question);
		reponse = reponseRepo.save(reponse);

		assertEquals("testQuestionQuery",
				questionrepo.findQuestionAndReponse(module1.getId()).get(0).getReponses().get(0).getEnonce());

	}

	@Test
	public void testQuestionCont() {

		int startNumber = questionCont.list().size();

		Question question1 = new Question();
		question1.setQuestion("testQuestionCont");
		question1 = questionCont.create(question1);
		question1 = questionCont.update(question1, question1.getId());

		assertEquals("testQuestionCont", questionCont.find(question1.getId()).getQuestion());

		int middleNumber = questionCont.list().size();
		assertEquals(1, (middleNumber - startNumber));

		questionCont.delete(question1.getId());

		int finalNumber = questionCont.list().size();

		assertEquals(0, finalNumber - startNumber);

	}

}
