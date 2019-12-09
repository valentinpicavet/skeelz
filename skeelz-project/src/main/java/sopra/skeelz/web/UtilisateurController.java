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

import sopra.skeelz.model.Entreprise;
import sopra.skeelz.model.Utilisateur;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IEntrepriseRepository;
import sopra.skeelz.repository.IUtilisateurRepository;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurController {
	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@Autowired
	private IEntrepriseRepository entrepriseRepo;

	@GetMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> list() {
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();

		return utilisateurs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur find(@PathVariable Long id) {
		Utilisateur utilisateur = utilisateurRepo.findById(id).get();

		return utilisateur;
	}
	
	@GetMapping("/identification/{identifiant}:{password}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur findByIdentifiantAndPassword(@PathVariable String identifiant, @PathVariable String password) {
		Utilisateur utilisateur = utilisateurRepo.findUtilisateurByIdentifiantAndPassword(identifiant, password);
		
		return utilisateur;
	}

	@GetMapping("/{id}/entreprise")
	@JsonView(Views.ViewUtilisateurEntreprise.class)
	public Entreprise findEntrepriseByUtilisateurId(@PathVariable Long id) {
		Entreprise entreprises = entrepriseRepo.findEntrepriseByUtilisateur(id);

		return entreprises;
	}

	@PostMapping("")
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		return utilisateurRepo.save(utilisateur);
	}

	@PutMapping("/{id}")
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
		return utilisateurRepo.save(utilisateur);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		utilisateurRepo.deleteById(id);
	}
}
