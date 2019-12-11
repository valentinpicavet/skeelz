package sopra.skeelz.web;

import java.util.ArrayList;
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
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.ISkeelzRepository;
import sopra.skeelz.web.dto.PersonneDTO;

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
	public List<PersonneDTO> list() {
		List<Personne> personnes = personneRepo.findAll();
		List<PersonneDTO> personneDTOs = new ArrayList<PersonneDTO>();

		for (Personne pers : personnes) {
			PersonneDTO persDTO = new PersonneDTO();
			persDTO.setId(pers.getId());
			persDTO.setVersion(pers.getVersion());
			persDTO.setNom(pers.getNom());
			persDTO.setPrenom(pers.getPrenom());
			persDTO.setTelephone(pers.getTelephone());
			persDTO.setNoteGlobal(pers.getNoteGlobal());
			persDTO.setUtilisateur(pers.getUtilisateur());
			persDTO.setCoursPersonne(pers.getCoursPersonne());
			persDTO.setQcmPersonne(pers.getQcmPersonne());
			persDTO.setBilanCompetence(pers.getBilanCompetence());
			persDTO.setCompetences(competenceRepo.findCompetenceByIdPersonne(pers.getId()));
			persDTO.setSkeelzs(skeelzRepo.findSkeelzByIdPersonne(pers.getId()));
			personneDTOs.add(persDTO);
		}
		return personneDTOs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPersonne.class)
	public PersonneDTO find(@PathVariable Long id) {
		Personne personne = personneRepo.findById(id).get();
	
		PersonneDTO personneDTO = new PersonneDTO();
		personneDTO.setId(personne.getId());
		personneDTO.setVersion(personne.getVersion());
		personneDTO.setNom(personne.getNom());
		personneDTO.setPrenom(personne.getPrenom());
		personneDTO.setTelephone(personne.getTelephone());
		personneDTO.setNoteGlobal(personne.getNoteGlobal());
		personneDTO.setUtilisateur(personne.getUtilisateur());
		personneDTO.setCoursPersonne(personne.getCoursPersonne());
		personneDTO.setQcmPersonne(personne.getQcmPersonne());
		personneDTO.setBilanCompetence(personne.getBilanCompetence());
		personneDTO.setCompetences(competenceRepo.findCompetenceByIdPersonne(personne.getId()));
		personneDTO.setSkeelzs(skeelzRepo.findSkeelzByIdPersonne(personne.getId()));
		
		return personneDTO;
	}
	
	@GetMapping("/utilisateur/{idUtilisateur}")
	@JsonView(Views.ViewPersonne.class)
	public PersonneDTO findByIdUtilisateur(@PathVariable Long idUtilisateur) {
		Personne personne = personneRepo.findByUtilisateurId(idUtilisateur);
	
		PersonneDTO personneDTO = new PersonneDTO();
		personneDTO.setId(personne.getId());
		personneDTO.setVersion(personne.getVersion());
		personneDTO.setNom(personne.getNom());
		personneDTO.setPrenom(personne.getPrenom());
		personneDTO.setTelephone(personne.getTelephone());
		personneDTO.setNoteGlobal(personne.getNoteGlobal());
		personneDTO.setUtilisateur(personne.getUtilisateur());
		personneDTO.setCoursPersonne(personne.getCoursPersonne());
		personneDTO.setQcmPersonne(personne.getQcmPersonne());
		personneDTO.setBilanCompetence(personne.getBilanCompetence());
		personneDTO.setCompetences(competenceRepo.findCompetenceByIdPersonne(personne.getId()));
		
		return personneDTO;
	}
	

	@GetMapping("/{id}/courss/{etatCours}")
	@JsonView(Views.ViewPersonneCourss.class)
	public List<Cours> findCours(@PathVariable Long id,@PathVariable EtatCours etatCours) {
		List<Cours> courss = coursRepo.findCoursByIdPersonne(id,etatCours);

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
	public Personne create(@RequestBody PersonneDTO personneDTO) {
		Personne personne = new Personne();

		personne.setId(personneDTO.getId());
		personne.setVersion(personneDTO.getVersion());
		personne.setNom(personneDTO.getNom());
		personne.setPrenom(personneDTO.getPrenom());
		personne.setTelephone(personneDTO.getTelephone());
		personne.setNoteGlobal(personneDTO.getNoteGlobal());
		personne.setUtilisateur(personneDTO.getUtilisateur());
		personne.setCoursPersonne(personneDTO.getCoursPersonne());
		personne.setQcmPersonne(personneDTO.getQcmPersonne());
		personne.setBilanCompetence(personneDTO.getBilanCompetence());

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
