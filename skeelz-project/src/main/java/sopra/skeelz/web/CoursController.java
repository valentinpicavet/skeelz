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
import sopra.skeelz.model.Cours;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.Module;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IChapitreRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IModuleRepository;

@RestController
@RequestMapping("/cours")
public class CoursController {
	
	@Autowired
	private ICoursRepository coursRepo;
	
	@Autowired
	private IModuleRepository moduleRepo;
	
	@Autowired
	private IChapitreRepository chapitreRepo;
	
	
	@GetMapping("")
	@JsonView(Views.ViewCours.class)
	public List<Cours> list() {
		List<Cours> courss = coursRepo.findAll();

		return courss;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCours.class)
	public Cours find(@PathVariable Long id) {
		Cours cours = coursRepo.findById(id).get();

		return cours;
	}
	@GetMapping("/by-etat/{etat}")
	@JsonView(Views.ViewCours.class)
	public List<Cours> findByEtat(@PathVariable String etat) {
		Etat eetat = Etat.valueOf(etat.toUpperCase());
		List<Cours> courss = coursRepo.findAllCoursByEtat(eetat);
	

		return courss;
	}
	
	@GetMapping("/{id}/modules")
	@JsonView(Views.ViewCoursModules.class)
	public List<Module> findModule(@PathVariable Long id) {
		List<Module> modules = moduleRepo.findModule(id);
	

		return modules;
	}
	
	@GetMapping("/{id}/modules/chapitres")
	@JsonView(Views.ViewCoursModulesChapitres.class)
	public List<Module> findModulesWithChapitres(@PathVariable Long id) {
		List<Module> modules = moduleRepo.findModulesWithChapitres(id);
	

		return modules;
	}
	
	@GetMapping("/{id}/chapitres")
	@JsonView(Views.ViewCoursChapitres.class)
	public List<Chapitre> findChapitre(@PathVariable Long id) {
		List<Chapitre> chapitres = chapitreRepo.findChapitre(id);
	

		return chapitres;
	}
	
	@GetMapping("/by-difficulte/{difficulte}")
	@JsonView(Views.ViewCours.class)
	public List<Cours> find(@PathVariable Difficulte difficulte) {
		List<Cours> courss = coursRepo.findAllCoursByDifficulte(difficulte);

		return courss;
	}
	@GetMapping("/by-intitule/{intitule}")
	@JsonView(Views.ViewCours.class)
	public List<Cours> find(@PathVariable String intitule) {
		List<Cours> courss = coursRepo.findAllCoursByIntitule(intitule);

		return courss;
	}
	

	@PostMapping("")
	public Cours create(@RequestBody Cours cours) {
		return coursRepo.save(cours);
	}

	@PutMapping("/{id}")
	public Cours update(@RequestBody Cours cours, @PathVariable Long id) {
		return coursRepo.save(cours);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		coursRepo.deleteById(id);
	}

}
