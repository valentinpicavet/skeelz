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

import sopra.skeelz.model.ElementDeCours;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IElementDeCoursRepository;


@RestController
@RequestMapping("/elementDeCours")
public class ElementDeCoursController {
	@Autowired
	private IElementDeCoursRepository elementDeCoursRepo;

	@GetMapping("")
	@JsonView(Views.ViewElementdeCours.class)
	public List<ElementDeCours> list() {
		List<ElementDeCours> elementDeCourss = elementDeCoursRepo.findAll();

		return elementDeCourss;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewElementdeCours.class)
	public ElementDeCours find(@PathVariable Long id) {
		ElementDeCours elementDeCours = elementDeCoursRepo.findById(id).get();

		return elementDeCours;
	}
	
	@GetMapping("/FindByIdChapitreAndAgencement/{idChapitre}:{agencement}")
	@JsonView(Views.ViewChapitreByAgencementIdChapitre.class)
	public ElementDeCours findElementDeCoursByChapitreAndAgencement(@PathVariable Long idChapitre, @PathVariable int agencement) {
		ElementDeCours elementDeCours = elementDeCoursRepo.findElementDeCoursByChapitreAndAgencement(idChapitre, agencement);

		return elementDeCours;
	}

	@PostMapping("")
	public ElementDeCours create(@RequestBody ElementDeCours elementDeCours) {
		return elementDeCoursRepo.save(elementDeCours);
	}

	@PutMapping("/{id}")
	public ElementDeCours update(@RequestBody ElementDeCours elementDeCours, @PathVariable Long id) {
		return elementDeCoursRepo.save(elementDeCours);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		elementDeCoursRepo.deleteById(id);
	}
}


