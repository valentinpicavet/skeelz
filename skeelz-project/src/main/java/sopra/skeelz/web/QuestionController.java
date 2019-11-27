package sopra.skeelz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.skeelz.model.Question;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IQuestionRepository;


@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionRepository questionRepo;

	@GetMapping("")
	@JsonView(Views.ViewQuestion.class)
	public List<Question> list() {
		List<Question> questions = questionRepo.findAll();

		return questions;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewQuestion.class)
	public Question find(@PathVariable Long id) {
		Question question = questionRepo.findById(id).get();

		return question;
	}

	@PostMapping("")
	public Question create(@RequestBody Question question) {
		return questionRepo.save(question);
	}

	@PutMapping("/{id}")
	public Question update(@RequestBody Question question, @PathVariable Long id) {
		return questionRepo.save(question);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		questionRepo.deleteById(id);
	}
}


