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

import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IPersonneRepository;


@RestController
@RequestMapping("/personne")
public class PersonneController {
	@Autowired
	private IPersonneRepository personneRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Personne> list() {
		List<Personne> personnes = personneRepo.findAll();

		return personnes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Personne find(@PathVariable Long id) {
		Personne personne = personneRepo.findById(id).get();

		return personne;
	}
	
	@PostMapping("")
	public Personne create(@RequestBody Personne personne) {
		return personneRepo.save(personne);
	}

	@PutMapping("/{id}")
	public Personne update(@RequestBody Personne personne, @PathVariable Long id) {
		return personneRepo.save(personne);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personneRepo.deleteById(id);
	}
}


