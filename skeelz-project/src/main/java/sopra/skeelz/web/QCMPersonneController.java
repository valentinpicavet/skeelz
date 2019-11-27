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

import sopra.skeelz.model.QCMPersonne;
import sopra.skeelz.model.Views;
import sopra.skeelz.repository.IQCMPersonneRepository;


@RestController
@RequestMapping("/qcmPersonne")
public class QCMPersonneController {
	@Autowired
	private IQCMPersonneRepository qcmPersonneRepo;

	@GetMapping("")
	@JsonView(Views.ViewQCMPersonne.class)
	public List<QCMPersonne> list() {
		List<QCMPersonne> qcmPersonnes = qcmPersonneRepo.findAll();

		return qcmPersonnes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewQCMPersonne.class)
	public QCMPersonne find(@PathVariable Long id) {
		QCMPersonne qcmPersonne = qcmPersonneRepo.findById(id).get();
		return qcmPersonne;
	}

	@PostMapping("")
	public QCMPersonne create(@RequestBody QCMPersonne qcmPersonne) {
		return qcmPersonneRepo.save(qcmPersonne);
	}

	@PutMapping("/{id}")
	public QCMPersonne update(@RequestBody QCMPersonne qcmPersonne, @PathVariable Long id) {
		return qcmPersonneRepo.save(qcmPersonne);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		qcmPersonneRepo.deleteById(id);
	}
}


