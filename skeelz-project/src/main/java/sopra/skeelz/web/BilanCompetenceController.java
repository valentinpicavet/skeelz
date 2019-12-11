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

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.RelationCours;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IBilanCompetenceRepository;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.repository.ICoursPersonneRepository;
import sopra.skeelz.repository.IPersonneRepository;

@RestController
@RequestMapping("/bilanCompetence")
@CrossOrigin("*")
public class BilanCompetenceController {

	@Autowired
	private IBilanCompetenceRepository bilanCompetenceRepo;
	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;
	@Autowired
	private ICoursPersonneRepository coursPersonneRepo;
	@Autowired
	private IPersonneRepository personneRepo;

	@GetMapping("")
	@JsonView(Views.ViewBilanCompetence.class)
	public List<BilanCompetence> list() {
		List<BilanCompetence> bilanCompetences = bilanCompetenceRepo.findAll();

		return bilanCompetences;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewBilanCompetence.class)
	public BilanCompetence find(@PathVariable Long id) {
		BilanCompetence bilanCompetence = bilanCompetenceRepo.findById(id).get();

		return bilanCompetence;
	}

	@GetMapping("/personne/{idPersonne}")
	@JsonView(Views.ViewBilanCompetence.class)
	public List<BilanCompetence> findByIdPersonne(@PathVariable Long idPersonne) {
		List<BilanCompetence> bilanCompetence = bilanCompetenceRepo.findByIdPersonne(idPersonne);

		return bilanCompetence;
	}

	@GetMapping("/reussi-cours/{idCoursPersonne}")
	@JsonView(Views.ViewBilanCompetence.class)
	public List<BilanCompetence> updateBilanCompetencePersonne(@PathVariable Long idCoursPersonne) {
		
		System.out.println("J'entre dans la méthode updateBilanCompetence");
		
		CoursPersonne coursPersonne = coursPersonneRepo.findById(idCoursPersonne).get();
		coursPersonne.setEtatCours(EtatCours.VALIDE);
		coursPersonne = coursPersonneRepo.save(coursPersonne);
		
		Personne personne = personneRepo.findById(coursPersonne.getPersonne().getId()).get();
		
		System.out.println("Nom de la personne : " + personne.getNom());
		
		List<CompetenceSkeelz> competenceSkeelz = competenceSkeelzRepo.findByIdCoursAndRelationCours(coursPersonne.getCours().getId(), RelationCours.VALIDE);
		
		System.out.println("Nombre de CS d'un cours et id du premier élément :");
		System.out.println(competenceSkeelz.size());
		System.out.println(competenceSkeelz.get(0).getId());
		
		List<BilanCompetence> bilanCompetence = bilanCompetenceRepo.findByIdPersonne(personne.getId());
		
		System.out.println("Nombre de BC d'une personne et id du premier élément");
		System.out.println(bilanCompetence.size());
		System.out.println(bilanCompetence.get(0).getId());
		
		for(CompetenceSkeelz cs : competenceSkeelz) {
			if(!bilanCompetence.stream()
					  .filter(bc -> cs.getId().equals(bc.getCompetenceSkeelz().getId())).findAny().isPresent()) {
				
				System.out.println("On entre dans le if");
				
				BilanCompetence newBC = new BilanCompetence();
				newBC.setCompetenceSkeelz(cs);
				newBC.setPersonne(personne);
				
				bilanCompetenceRepo.save(newBC);
			}
		}
		
		return bilanCompetenceRepo.findByIdPersonne(personne.getId());
	}

	@PostMapping("")
	public BilanCompetence create(@RequestBody BilanCompetence bilanCompetence) {
		return bilanCompetenceRepo.save(bilanCompetence);
	}

	@PutMapping("/{id}")
	public BilanCompetence update(@RequestBody BilanCompetence bilanCompetence, @PathVariable Long id) {
		return bilanCompetenceRepo.save(bilanCompetence);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		bilanCompetenceRepo.deleteById(id);
	}

}
