package sopra.skeelz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.skeelz.model.CoursCompetence;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICoursCompetenceRepository;

@RestController
@RequestMapping("/coursCompetence")
@CrossOrigin("*")
public class CoursCompetenceController {
	
	@Autowired
	private ICoursCompetenceRepository coursCompetenceRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewCoursCompetence.class)
	public List<CoursCompetence> list() {
		List<CoursCompetence> coursCompetences = coursCompetenceRepo.findAll();

		return coursCompetences;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCoursCompetence.class)
	public CoursCompetence find(@PathVariable Long id) {
		CoursCompetence coursCompetence = coursCompetenceRepo.findById(id).get();

		return coursCompetence;
	}

	@PostMapping("")
	public CoursCompetence create(@RequestBody CoursCompetence coursCompetence) {
		return coursCompetenceRepo.save(coursCompetence);
	}

	@PutMapping("/{id}")
	public CoursCompetence update(@RequestBody CoursCompetence coursCompetence, @PathVariable Long id) {
		return coursCompetenceRepo.save(coursCompetence);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		coursCompetenceRepo.deleteById(id);
	}

}
