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

import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.RelationCours;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;

@RestController
@RequestMapping("/competenceSkeelz")
@CrossOrigin("*")
public class CompetenceSkeelzController {

	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;

	@GetMapping("")
	@JsonView(Views.ViewCompetenceSkeelz.class)
	public List<CompetenceSkeelz> list() {
		List<CompetenceSkeelz> competenceSkeelzs = competenceSkeelzRepo.findAll();

		return competenceSkeelzs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCompetenceSkeelz.class)
	public CompetenceSkeelz find(@PathVariable Long id) {
		CompetenceSkeelz competenceSkeelz = competenceSkeelzRepo.findById(id).get();

		return competenceSkeelz;
	}
	
	@GetMapping("/personne/{idPersonne}")
	@JsonView(Views.ViewCompetenceSkeelz.class)
	public List<CompetenceSkeelz> findByIdPersonne(@PathVariable Long idPersonne) {
		List<CompetenceSkeelz> competenceSkeelzs = competenceSkeelzRepo.findByIdPersonne(idPersonne);

		return competenceSkeelzs;
	}
	
	@GetMapping("/cours-valide/{idCours}:{relationCours}")
	@JsonView(Views.ViewCompetenceSkeelz.class)
	public List<CompetenceSkeelz> findByIdCoursAndRelationCours(@PathVariable Long idCours, @PathVariable RelationCours relationCours) {
		List<CompetenceSkeelz> competenceSkeelzs = competenceSkeelzRepo.findByIdCoursAndRelationCours(idCours, relationCours);

		return competenceSkeelzs;
	}

	@PostMapping("")
	@JsonView(Views.ViewCompetenceSkeelz.class)
	public CompetenceSkeelz create(@RequestBody CompetenceSkeelz competenceSkeelz) {
		return competenceSkeelzRepo.save(competenceSkeelz);
	}

	@PutMapping("/{id}")
	public CompetenceSkeelz update(@RequestBody CompetenceSkeelz competenceSkeelz, @PathVariable Long id) {
		return competenceSkeelzRepo.save(competenceSkeelz);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		competenceSkeelzRepo.deleteById(id);
	}

}
