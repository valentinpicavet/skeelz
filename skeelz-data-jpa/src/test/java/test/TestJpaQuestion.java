package test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IQuestionRepository;
import skeelz.modele.Question;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/application-context.xml")
public class TestJpaQuestion {
	
	
	@Autowired
	private IQuestionRepository questionrepo;
	
	
	@Test
	public void testQuestion() {
		
int startNumber = questionrepo.findAll().size();
		
		Question question1 = new Question ();
		
		question1.setQuestion("question 1 test");
		
	

		
		
		question1 = questionrepo.save(question1);
		
		
		
		Optional<Question> question1Find = questionrepo.findById(question1.getId());
		
		Assert.assertEquals("question 1 test", question1Find.get().getQuestion());

		
		int middleNumber = questionrepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		questionrepo.delete(question1);
		
		int finalNumber = questionrepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
		
	
	}

}
