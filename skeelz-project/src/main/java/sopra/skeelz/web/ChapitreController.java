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

import sopra.skeelz.model.Chapitre;
import sopra.skeelz.model.ElementDeCours;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IChapitreRepository;
import sopra.skeelz.repository.IElementDeCoursRepository;

@RestController
@RequestMapping("/chapitre")
public class ChapitreController {
	@Autowired
	private IChapitreRepository chapitreRepo;

	@Autowired
	private IElementDeCoursRepository elementDeCoursRepo;

	@GetMapping("")
	@JsonView(Views.ViewChapitre.class)
	public List<Chapitre> list() {
		List<Chapitre> chapitres = chapitreRepo.findAll();

		return chapitres;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewChapitre.class)
	public Chapitre find(@PathVariable Long id) {
		Chapitre chapitre = chapitreRepo.findById(id).get();

		return chapitre;
	}

	@GetMapping("/FindByIdModuleAndAgencement/{idModule}:{agencement}")
	@JsonView(Views.ViewModuleByAgencementIdModule.class)
	public Chapitre findChapitreByModuleAndAgencement(@PathVariable Long idModule, @PathVariable int agencement) {
		Chapitre chapitre = chapitreRepo.findChapitreByModuleAndAgencement(idModule, agencement);

		return chapitre;
	}

	@GetMapping("/{id}/elementDeCourss")
	@JsonView(Views.ViewChapitreElementDeCourss.class)
	public List<ElementDeCours> listElementCours(@PathVariable Long id) {
		List<ElementDeCours> elementDeCourss = elementDeCoursRepo.findElementDeCours(id);

		return elementDeCourss;
	}

	@PostMapping("")
	public Chapitre create(@RequestBody Chapitre chapitre) {
		return chapitreRepo.save(chapitre);
	}

	@PutMapping("/{id}")
	public Chapitre update(@RequestBody Chapitre chapitre, @PathVariable Long id) {
		return chapitreRepo.save(chapitre);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		chapitreRepo.deleteById(id);
	}
}
