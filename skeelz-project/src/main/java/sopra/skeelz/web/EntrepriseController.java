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
import sopra.skeelz.model.Entreprise;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.model.Utilisateur;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IEntrepriseRepository;
import sopra.skeelz.repository.ISkeelzRepository;
import sopra.skeelz.repository.IUtilisateurRepository;


@RestController
@RequestMapping("/entreprise")
@CrossOrigin("*")
public class EntrepriseController {
	@Autowired
	private IEntrepriseRepository entrepriseRepo;
	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	
	@Autowired
	private ICoursRepository coursRepo;
	
	@Autowired
	private ICompetenceRepository competenceRepo;
	
	@Autowired
	private ISkeelzRepository skeelzRepo;

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
	
	@GetMapping("/{id}/utilisateurs")
	@JsonView(Views. ViewEntrepriseUtilisateurs.class)
	public List<Utilisateur> findUtilisateur(@PathVariable Long id) {
		List<Utilisateur> utilisateurs = utilisateurRepo.findUtilisateurByIdEntreprise(id);

		return utilisateurs;
	}
	
	@GetMapping("/{id}/courss")
	@JsonView(Views. ViewEntrepriseCourss.class)
	public List<Cours> findCours(@PathVariable Long id) {
		List<Cours> courss = coursRepo.findCoursByIdEntreprise(id);

		return courss;
	}
	
	@GetMapping("/{id}/competences")
	@JsonView(Views. ViewEntrepriseCompetences.class)
	public List<Competence> findCompetence(@PathVariable Long id) {
		List<Competence> competences = competenceRepo.findCompetenceByIdEntreprise(id);

		return competences;
	}
	
	@GetMapping("/{id}/skeelzs")
	@JsonView(Views. ViewEntrepriseSkeelzs.class)
	public List<Skeelz> findSkeelz(@PathVariable Long id) {
		List<Skeelz> skeelzs = skeelzRepo.findSkeelzByIdEntreprise(id);

		return skeelzs;
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


