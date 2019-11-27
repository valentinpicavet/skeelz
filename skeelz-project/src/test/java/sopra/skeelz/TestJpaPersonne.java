package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Personne;
import sopra.skeelz.repository.IPersonneRepository;

@SpringBootTest
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
		
		assertEquals("JEAN", maPersonneFind.get().getNom());
		assertEquals("Paul", maPersonneFind.get().getPrenom());
		assertEquals("026134515", maPersonneFind.get().getTelephone());
		assertEquals(23, maPersonneFind.get().getNoteGlobal());
		
		int middleNumber = personneRepo.findAll().size();
	
		assertEquals(1, (middleNumber - startNumber));
		
		personneRepo.delete(maPersonne);
		
		int finalNumber = personneRepo.findAll().size();
		
		assertEquals(0, (finalNumber - startNumber));


	}

}
