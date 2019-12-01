package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.Module;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.QCMPersonne;
import sopra.skeelz.repository.IModuleRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.IQCMPersonneRepository;
import sopra.skeelz.web.QCMPersonneController;

@SpringBootTest
public class TestJpaQCMPersonne {

	@Autowired
	private IQCMPersonneRepository QCMPersonnerepo;
	@Autowired
	private QCMPersonneController QCMPersonneCont;
	@Autowired
	private IPersonneRepository personneRepo;
	@Autowired
	private IModuleRepository moduleRepo;

	@Test
	public void testQCMPersonne() {

		int startNumber = QCMPersonnerepo.findAll().size();

		QCMPersonne qcmPersonne1 = new QCMPersonne();

		qcmPersonne1.setNbTentative(4);
		qcmPersonne1.setStatutQCM(true);

		qcmPersonne1 = QCMPersonnerepo.save(qcmPersonne1);

		Optional<QCMPersonne> qcmPersonne1Find = QCMPersonnerepo.findById(qcmPersonne1.getId());

		assertEquals(4, qcmPersonne1Find.get().getNbTentative());

		int middleNumber = QCMPersonnerepo.findAll().size();
		assertEquals(1, (middleNumber - startNumber));

		QCMPersonnerepo.delete(qcmPersonne1);

		int finalNumber = QCMPersonnerepo.findAll().size();

		assertEquals(0, finalNumber - startNumber);

	}
	
	@Test
	public void testQCMPersonneQuery() {

		
		Personne maPersonne = new Personne();
		maPersonne.setNom("nomQCMQuery");
		maPersonne.setPrenom("prenomQCMQuery");
		maPersonne.setTelephone("026134515");
		maPersonne.setNoteGlobal(23);
		maPersonne = personneRepo.save(maPersonne);
		
		Module module1 = new Module();
		module1.setIntitule("intituleQCMQuery");
		module1.setAgencement(1);
		module1.setEnonceQCM("enonceQCMQuery");
		module1.setPeriodicite(5);
		module1.setNbTentativeAutorise(4);
		module1 = moduleRepo.save(module1);
		
		
		QCMPersonne qcmPersonne1 = new QCMPersonne();
		qcmPersonne1.setNbTentative(4);
		qcmPersonne1.setPersonne(maPersonne);
		qcmPersonne1.setModule(module1);
		qcmPersonne1.setStatutQCM(true);
		qcmPersonne1 = QCMPersonnerepo.save(qcmPersonne1);


		assertEquals(4, QCMPersonnerepo.findByPersonneAndModule(maPersonne.getId(), module1.getId()).getNbTentative());

	}
	
	@Test
	public void testQCMPersonneCont() {

		int startNumber = QCMPersonneCont.list().size();

		Personne maPersonne = new Personne();
		maPersonne.setNom("nomQCMCont");
		maPersonne.setPrenom("prenomQCMCont");
		maPersonne.setTelephone("026134515");
		maPersonne.setNoteGlobal(23);
		maPersonne = personneRepo.save(maPersonne);
		
		Module module1 = new Module();
		module1.setIntitule("intituleQCMCont");
		module1.setAgencement(1);
		module1.setEnonceQCM("enonceQCMCont");
		module1.setPeriodicite(5);
		module1.setNbTentativeAutorise(4);
		module1 = moduleRepo.save(module1);
		
		
		QCMPersonne qcmPersonne1 = new QCMPersonne();
		qcmPersonne1.setNbTentative(4);
		qcmPersonne1.setStatutQCM(true);
		qcmPersonne1.setPersonne(maPersonne);
		qcmPersonne1.setModule(module1);
		qcmPersonne1 = QCMPersonneCont.create(qcmPersonne1);
		qcmPersonne1 = QCMPersonneCont.update(qcmPersonne1, qcmPersonne1.getId());


		assertEquals(4, QCMPersonneCont.find(qcmPersonne1.getId()).getNbTentative());
		assertEquals(4, QCMPersonneCont.findByPersonneAndModule(maPersonne.getId(), module1.getId()).getNbTentative());

		int middleNumber = QCMPersonneCont.list().size();
		assertEquals(1, (middleNumber - startNumber));


	}
	@Test
	public void testQCMPersonneContBis() {
		QCMPersonne qcmPersonne1 = new QCMPersonne();
		qcmPersonne1.setNbTentative(4);
		qcmPersonne1.setStatutQCM(true);
		qcmPersonne1 = QCMPersonneCont.create(qcmPersonne1);
		QCMPersonneCont.delete(qcmPersonne1.getId());
	}
		



		

}
