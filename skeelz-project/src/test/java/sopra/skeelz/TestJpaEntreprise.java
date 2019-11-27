package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import sopra.skeelz.model.Entreprise;
import sopra.skeelz.repository.IEntrepriseRepository;


public class TestJpaEntreprise {

	@Autowired
	private IEntrepriseRepository entrepriseRepo;
	
	@Test
	public void testEntreprise() {
	
	int startNumber = entrepriseRepo.findAll().size();
	
	Entreprise sopra = new Entreprise();
	sopra.setNom("Sopra Steria");
	sopra.setNumeroSiret("ST0045");
	sopra.setTypeContrat("Contrat de ouf");
	
	sopra = entrepriseRepo.save(sopra);
	
	Optional<Entreprise>sopraFind = entrepriseRepo.findById(sopra.getId());
	
	assertEquals("Sopra Steria", sopraFind.get().getNom());
	assertEquals("ST0045", sopraFind.get().getNumeroSiret());
	assertEquals("ST0045", sopraFind.get().getNumeroSiret());
	
	int middleNumber = entrepriseRepo.findAll().size();
	
	assertEquals(1, (middleNumber - startNumber));
	
	entrepriseRepo.delete(sopra);
	
	int finalNumber = entrepriseRepo.findAll().size();
	
	assertEquals(0, (finalNumber - startNumber));

	
	}
}
