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

import sopra.skeelz.model.Competence;
import sopra.skeelz.model.Cours;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.ISkeelzRepository;

@RestController
@RequestMapping("/personne")
@CrossOrigin("*")
public class PersonneController {
	@Autowired
	private IPersonneRepository personneRepo;

	@Autowired
	private ICoursRepository coursRepo;

	@Autowired
	private ICompetenceRepository competenceRepo;

	@Autowired
	private ISkeelzRepository skeelzRepo;

	@GetMapping("")
	@JsonView(Views.ViewPersonne.class)
	public List<Personne> list() {
		List<Personne> personnes = personneRepo.findAll();

		return personnes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPersonne.class)
	public Personne find(@PathVariable Long id) {
		Personne personne = personneRepo.findById(id).get();

		return personne;
	}

	@GetMapping("/{id}/courss")
	@JsonView(Views.ViewPersonneCourss.class)
	public List<Cours> findCours(@PathVariable Long id) {
		List<Cours> courss = coursRepo.findCoursByIdPersonne(id);

		return courss;
	}

	@GetMapping("/{id}/competences")
	@JsonView(Views.ViewPersonneCompetences.class)
	public List<Competence> findCompetence(@PathVariable Long id) {
		List<Competence> competences = competenceRepo.findCompetenceByIdPersonne(id);

		return competences;
	}

	@GetMapping("/{id}/skeelzs")
	@JsonView(Views.ViewPersonneSkeelzs.class)
	public List<Skeelz> findSkeelz(@PathVariable Long id) {
		List<Skeelz> skeelzs = skeelzRepo.findSkeelzByIdPersonne(id);

		return skeelzs;
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
