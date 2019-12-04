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

import sopra.skeelz.model.Chapitre;
import sopra.skeelz.model.Module;
import sopra.skeelz.model.Question;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IChapitreRepository;
import sopra.skeelz.repository.IModuleRepository;
import sopra.skeelz.repository.IQuestionRepository;

@RestController
@RequestMapping("/module")
@CrossOrigin("*")
public class ModuleController {
	@Autowired
	private IModuleRepository moduleRepo;
	@Autowired
	private IQuestionRepository questionRepo;
	@Autowired
	private IChapitreRepository chapitreRepo;

	@GetMapping("")
	@JsonView(Views.ViewModule.class)
	public List<Module> list() {
		List<Module> modules = moduleRepo.findAll();

		return modules;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewModule.class)
	public Module find(@PathVariable Long id) {
		Module module = moduleRepo.findById(id).get();

		return module;
	}

	@GetMapping("/FindByIdCoursAndAgencement/{idCours}:{agencement}")
	@JsonView(Views.ViewCoursModuleByAgencement.class)
	public Module findModuleByCoursAndAgencement(@PathVariable Long idCours, @PathVariable int agencement) {
		Module module = moduleRepo.findModuleByCoursAndAgencement(idCours, agencement);

		return module;
	}

	@GetMapping("/{id}/questionsAndReponses")
	@JsonView(Views.ViewModuleQuestionReponse.class)
	public List<Question> findQuestionAndReponse(@PathVariable Long id) {
		List<Question> questions = questionRepo.findQuestionAndReponse(id);

		return questions;
	}

	@GetMapping("/{id}/chapitres")
	@JsonView(Views.ViewModuleChapitres.class)
	public List<Chapitre> findChapitre(@PathVariable Long id) {
		List<Chapitre> chapitres = chapitreRepo.findChapitreByModuleId(id);

		return chapitres;
	}

	@PostMapping("")
	public Module create(@RequestBody Module module) {
		return moduleRepo.save(module);
	}

	@PutMapping("/{id}")
	public Module update(@RequestBody Module module, @PathVariable Long id) {
		return moduleRepo.save(module);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		moduleRepo.deleteById(id);
	}
}
