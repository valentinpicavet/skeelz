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

import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICoursPersonneRepository;

@RestController
@RequestMapping("/CoursPersonne")
public class CoursPersonneController {
	
	@Autowired
	private ICoursPersonneRepository coursPersonneRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewCoursPersonne.class)
	public List<CoursPersonne> list() {
		List<CoursPersonne> coursPersonnes = coursPersonneRepo.findAll();

		return coursPersonnes;
	}


	@PostMapping("")
	public CoursPersonne create(@RequestBody CoursPersonne coursPersonne) {
		return coursPersonneRepo.save(coursPersonne);
	}

	@PutMapping("/{id}")
	public CoursPersonne update(@RequestBody CoursPersonne coursPersonne, @PathVariable Long id) {
		return coursPersonneRepo.save(coursPersonne);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		coursPersonneRepo.deleteById(id);
	}

}
