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
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.ISkeelzRepository;

@RestController
@RequestMapping("/skeelz")
public class SkeelzController {

	@Autowired
	private ISkeelzRepository skeelzRepo;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private ICoursRepository coursRepo;

	@GetMapping("")
	@JsonView(Views.ViewSkeelz.class)
	public List<Skeelz> list() {
		List<Skeelz> skeelzs = skeelzRepo.findAll();

		return skeelzs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSkeelz.class)
	public Skeelz find(@PathVariable Long id) {
		Skeelz skeelz = skeelzRepo.findById(id).get();

		return skeelz;
	}

	@GetMapping("/{id}/personnes")
	@JsonView(Views.ViewSkeelzPersonnes.class)
	public List<Personne> findPersonneBySkeelzId(@PathVariable Long id) {
		List<Personne> personnes = personneRepo.findPersonneBySkeelz(id);

		return personnes;
	}

	@GetMapping("/{id}/courss")
	@JsonView(Views.ViewSkeelzCours.class)
	public List<Cours> findCoursBySkeelzId(@PathVariable Long id) {
		List<Cours> courss = coursRepo.findCoursBySkeelz(id);

		return courss;
	}

	@PostMapping("")
	public Skeelz create(@RequestBody Skeelz skeelz) {
		return skeelzRepo.save(skeelz);
	}

	@PutMapping("/{id}")
	public Skeelz update(@RequestBody Skeelz skeelz, @PathVariable Long id) {
		return skeelzRepo.save(skeelz);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		skeelzRepo.deleteById(id);
	}

}
