package sopra.skeelz;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IPersonneRepository;
import skeelz.modele.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class TestJpaPersonne {

	@Autowired
	private IPersonneRepository personneRepo;
	
	@Test
	public void testPersonne() {

		int startNumber = personneRepo.findAll().size();

		Personne maPersonne = new Personne();
		maPersonne.setNom("JEAN");
		maPersonne.setPrenom("Paul");
		maPersonne.setTelephone("026134515");
		maPersonne.setNoteGlobal(23);
		
		
		maPersonne = personneRepo.save(maPersonne);


		Optional<Personne> maPersonneFind = personneRepo.findById(maPersonne.getId());
		
		Assert.assertEquals("JEAN", maPersonneFind.get().getNom());
		Assert.assertEquals("Paul", maPersonneFind.get().getPrenom());
		Assert.assertEquals("026134515", maPersonneFind.get().getTelephone());
		Assert.assertEquals(23, maPersonneFind.get().getNoteGlobal());
		
		int middleNumber = personneRepo.findAll().size();
	
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		personneRepo.delete(maPersonne);
		
		int finalNumber = personneRepo.findAll().size();
		
		Assert.assertEquals(0, (finalNumber - startNumber));


	}

}
