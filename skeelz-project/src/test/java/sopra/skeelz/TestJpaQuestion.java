package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Question;
import sopra.skeelz.repository.IQuestionRepository;

@SpringBootTest
public class TestJpaQuestion {

	@Autowired
	private IQuestionRepository questionrepo;

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

}
