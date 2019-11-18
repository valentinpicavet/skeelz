package test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IEntrepriseRepository;
import skeelz.modele.Entreprise;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
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
	
	Assert.assertEquals("Sopra Steria", sopraFind.get().getNom());
	Assert.assertEquals("ST0045", sopraFind.get().getNumeroSiret());
	Assert.assertEquals("ST0045", sopraFind.get().getNumeroSiret());
	
	int middleNumber = entrepriseRepo.findAll().size();
	
	Assert.assertEquals(1, (middleNumber - startNumber));
	
	entrepriseRepo.delete(sopra);
	
	int finalNumber = entrepriseRepo.findAll().size();
	
	Assert.assertEquals(0, (finalNumber - startNumber));

	
	}
}
