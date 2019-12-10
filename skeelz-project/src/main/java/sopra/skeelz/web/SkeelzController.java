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

import sopra.skeelz.model.Cours;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.ISkeelzRepository;
import sopra.skeelz.web.dto.PersonneDTO;

@RestController
@RequestMapping("/skeelz")
@CrossOrigin("*")
public class SkeelzController {

	@Autowired
	private ISkeelzRepository skeelzRepo;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;

	@GetMapping("")
	@JsonView(Views.ViewSkeelz.class)
	public List<Skeelz> list() {
		List<Skeelz> skeelzs = skeelzRepo.findAll();

		return skeelzs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSkeelz.class)
	public Skeelz find(@PathVariable Long id) {
		Skeelz skeelz = skeelzRepo.findById(id).get();

		return skeelz;
	}

	@GetMapping("/{id}/personnes")
	@JsonView(Views.ViewPersonne.class)
	public List<PersonneDTO> findPersonneBySkeelzId(@PathVariable Long id) {
		List<Personne> personnes = personneRepo.findPersonneBySkeelz(id);
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

	@GetMapping("/{id}/courss/{etat}")
	@JsonView(Views.ViewSkeelzCours.class)
	public List<Cours> findCoursBySkeelzId(@PathVariable Long id, @PathVariable Etat etat) {
		List<Cours> courss = coursRepo.findCoursBySkeelzEtat(id, etat);

		return courss;
	}
	@GetMapping("/{id}/courss")
	@JsonView(Views.ViewSkeelzCours.class)
	public List<Cours> findCoursBySkeelzId(@PathVariable Long id) {
		List<Cours> courss = coursRepo.findCoursBySkeelz(id );

		return courss;
	}


	@PostMapping("")
	public Skeelz create(@RequestBody Skeelz skeelz) {
		return skeelzRepo.save(skeelz);
	}

	@PutMapping("/{id}")
	public Skeelz update(@RequestBody Skeelz skeelz, @PathVariable Long id) {
		return skeelzRepo.save(skeelz);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		skeelzRepo.deleteById(id);
	}

}
