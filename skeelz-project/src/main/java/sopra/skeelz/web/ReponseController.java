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

import sopra.skeelz.model.Reponse;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IReponseRepository;

@RestController
@RequestMapping("/reponse")
public class ReponseController {
	@Autowired
	private IReponseRepository reponseRepo;

	@GetMapping("")
	@JsonView(Views.ViewReponse.class)
	public List<Reponse> list() {
		List<Reponse> reponses = reponseRepo.findAll();

		return reponses;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewReponse.class)
	public Reponse find(@PathVariable Long id) {
		Reponse reponse = reponseRepo.findById(id).get();

		return reponse;
	}

	@PostMapping("")
	public Reponse create(@RequestBody Reponse reponse) {
		return reponseRepo.save(reponse);
	}

	@PutMapping("/{id}")
	public Reponse update(@RequestBody Reponse reponse, @PathVariable Long id) {
		return reponseRepo.save(reponse);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		reponseRepo.deleteById(id);
	}
}
