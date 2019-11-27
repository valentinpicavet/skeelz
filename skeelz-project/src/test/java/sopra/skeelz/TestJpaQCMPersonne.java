package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.QCMPersonne;
import sopra.skeelz.repository.IQCMPersonneRepository;

@SpringBootTest
public class TestJpaQCMPersonne {

	@Autowired
	private IQCMPersonneRepository QCMPersonnerepo;

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

}
