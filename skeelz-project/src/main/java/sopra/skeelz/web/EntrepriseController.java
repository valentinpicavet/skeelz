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

import sopra.skeelz.model.Entreprise;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IEntrepriseRepository;


@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {
	@Autowired
	private IEntrepriseRepository entrepriseRepo;

	@GetMapping("")
	@JsonView(Views. ViewEntreprise.class)
	public List<Entreprise> list() {
		List<Entreprise> entreprises = entrepriseRepo.findAll();

		return entreprises;
	}

	@GetMapping("/{id}")
	@JsonView(Views. ViewEntreprise.class)
	public Entreprise find(@PathVariable Long id) {
		Entreprise entreprise = entrepriseRepo.findById(id).get();

		return entreprise;
	}

	@PostMapping("")
	public Entreprise create(@RequestBody Entreprise entreprise) {
		return entrepriseRepo.save(entreprise);
	}

	@PutMapping("/{id}")
	public Entreprise update(@RequestBody Entreprise entreprise, @PathVariable Long id) {
		return entrepriseRepo.save(entreprise);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		entrepriseRepo.deleteById(id);
	}
}


