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

import sopra.skeelz.model.Cours;
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICoursPersonneRepository;

@RestController
@RequestMapping("/CoursPersonne")
@CrossOrigin("*")
public class CoursPersonneController {

	@Autowired
	private ICoursPersonneRepository coursPersonneRepo;

	@GetMapping("")
	@JsonView(Views.ViewCoursPersonne.class)
	public List<CoursPersonne> list() {
		List<CoursPersonne> coursPersonnes = coursPersonneRepo.findAll();

		return coursPersonnes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCoursPersonne.class)
	public CoursPersonne find(@PathVariable Long id) {
		CoursPersonne coursPersonne = coursPersonneRepo.findById(id).get();

		return coursPersonne;
	}
	
	@GetMapping("/personneAndCours/{idPersonne}:{idCours}")
	@JsonView(Views.ViewCoursPersonneDetail.class)
	public CoursPersonne findByPersonneIdAndCours(@PathVariable Long idPersonne, @PathVariable Long idCours) {
		CoursPersonne coursPersonne = coursPersonneRepo.findCoursByIdPersonneAndIdCours(idPersonne, idCours);

		return coursPersonne;
	}

	@GetMapping("/{id}:{etatCours}/detail")
	@JsonView(Views.ViewCoursPersonneDetail.class)
	public List<Cours> find(@PathVariable Long id, @PathVariable EtatCours etatCours) {
		List<Cours> courss = coursPersonneRepo.findCoursByIdPersonneEtatCours(id, etatCours);

		return courss;
	}
	
	@GetMapping("/personne/{idPersonne}")
	@JsonView(Views.ViewCoursPersonneDetail.class)
	public List<CoursPersonne> findByIdPersonne(@PathVariable Long idPersonne) {
		List<CoursPersonne> coursPersonne = coursPersonneRepo.findByIdPersonne(idPersonne);
		return coursPersonne;
	}

	@PostMapping("")
	public CoursPersonne create(@RequestBody CoursPersonne coursPersonne) {
		return coursPersonneRepo.save(coursPersonne);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCoursPersonne.class)
	public CoursPersonne update(@RequestBody CoursPersonne coursPersonne, @PathVariable Long id) {
		return coursPersonneRepo.save(coursPersonne);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		coursPersonneRepo.deleteById(id);
	}

}
