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
import sopra.skeelz.model.RelationCours;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IPersonneRepository;

@RestController
@RequestMapping("/competence")
@CrossOrigin("*")
public class CompetenceController {

	@Autowired
	private ICompetenceRepository competenceRepo;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private ICoursRepository coursRepo;

	@GetMapping("")
	@JsonView(Views.ViewCompetence.class)
	public List<Competence> list() {
		List<Competence> competences = competenceRepo.findAll();

		return competences;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCompetence.class)
	public Competence find(@PathVariable Long id) {
		Competence competence = competenceRepo.findById(id).get();

		return competence;
	}

	@GetMapping("/{id}/personnes")
	@JsonView(Views.ViewCompetencePersonne.class)
	public List<Personne> findByCompetence(@PathVariable Long id) {
		List<Personne> personnes = personneRepo.findPersonneByIdCompetence(id);

		return personnes;
	}

	@GetMapping("/{id}:{relationCours}/cours/relations")
	@JsonView(Views.ViewCompetenceCoursAndRelation.class)
	public List<Cours> findByCompetenceAndRelationCours(@PathVariable Long id, @PathVariable String relationCours) {
		RelationCours relationCour = RelationCours.valueOf(relationCours.toUpperCase());
		List<Cours> courss = coursRepo.findAllCoursByCompetenceAndRelationCours(id, relationCour);

		return courss;
	}

	@PostMapping("")
	public Competence create(@RequestBody Competence competence) {
		return competenceRepo.save(competence);
	}

	@PutMapping("/{id}")
	public Competence update(@RequestBody Competence competence, @PathVariable Long id) {
		return competenceRepo.save(competence);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		competenceRepo.deleteById(id);
	}

}
