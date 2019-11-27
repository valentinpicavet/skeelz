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

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IBilanCompetenceRepository;

@RestController
@RequestMapping("/bilanCompetence")
public class BilanCompetenceController {
	
	@Autowired
	private IBilanCompetenceRepository bilanCompetenceRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewBilanCompetence.class)
	public List<BilanCompetence> list() {
		List<BilanCompetence> bilanCompetences = bilanCompetenceRepo.findAll();

		return bilanCompetences;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewBilanCompetence.class)
	public BilanCompetence find(@PathVariable Long id) {
		BilanCompetence bilanCompetence = bilanCompetenceRepo.findById(id).get();

		return bilanCompetence;
	}

	@PostMapping("")
	public BilanCompetence create(@RequestBody BilanCompetence bilanCompetence) {
		return bilanCompetenceRepo.save(bilanCompetence);
	}

	@PutMapping("/{id}")
	public BilanCompetence update(@RequestBody BilanCompetence bilanCompetence, @PathVariable Long id) {
		return bilanCompetenceRepo.save(bilanCompetence);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		bilanCompetenceRepo.deleteById(id);
	}

}
