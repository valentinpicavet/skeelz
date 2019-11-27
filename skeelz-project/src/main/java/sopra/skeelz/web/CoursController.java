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

import sopra.skeelz.model.Cours;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICoursRepository;

@RestController
@RequestMapping("/cours")
public class CoursController {
	
	@Autowired
	private ICoursRepository coursRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewCours.class)
	public List<Cours> list() {
		List<Cours> courss = coursRepo.findAll();

		return courss;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCoursDetail.class)
	public Cours find(@PathVariable Long id) {
		List<Cours> courss = coursRepo.findAllCoursByCompetence();

		return (Cours) courss;
	}

	@PostMapping("")
	public Cours create(@RequestBody Cours cours) {
		return coursRepo.save(cours);
	}

	@PutMapping("/{id}")
	public Cours update(@RequestBody Cours cours, @PathVariable Long id) {
		return coursRepo.save(cours);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		coursRepo.deleteById(id);
	}

}
