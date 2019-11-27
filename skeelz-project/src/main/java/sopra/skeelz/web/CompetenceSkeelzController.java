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

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.model.Views;
import sopra.skeelz.model.Views.ViewSkeelz;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.repository.ISkeelzRepository;

@RestController
@RequestMapping("/competenceSkeelz")
public class CompetenceSkeelzController {
	
	@Autowired
	private ICompetenceSkeelzRepository competenceSkeelzRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewCompetenceSkeelz.class)
	public List<CompetenceSkeelz> list() {
		List<CompetenceSkeelz> competenceSkeelzs = competenceSkeelzRepo.findAll();

		return competenceSkeelzs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCompetenceSkeelz.class)
	public CompetenceSkeelz find(@PathVariable Long id) {
		CompetenceSkeelz competenceSkeelz = competenceSkeelzRepo.findById(id).get();

		return competenceSkeelz;
	}

	@PostMapping("")
	public CompetenceSkeelz create(@RequestBody CompetenceSkeelz competenceSkeelz) {
		return competenceSkeelzRepo.save(competenceSkeelz);
	}

	@PutMapping("/{id}")
	public CompetenceSkeelz update(@RequestBody CompetenceSkeelz competenceSkeelz, @PathVariable Long id) {
		return competenceSkeelzRepo.save(competenceSkeelz);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		competenceSkeelzRepo.deleteById(id);
	}

}
