package test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IQCMPersonneRepository;
import skeelz.modele.QCMPersonne;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/application-context.xml")
public class TestJpaQCMPersonne {
	
	
	@Autowired
	private IQCMPersonneRepository QCMPersonnerepo;
	
	
	@Test
	public void testQCMPersonne() {
		
int startNumber = QCMPersonnerepo.findAll().size();
		
		QCMPersonne qcmPersonne1 = new QCMPersonne ();
		
		qcmPersonne1.setNbTentative(4);
		qcmPersonne1.setStatutQCM(true);

		
		
		qcmPersonne1 = QCMPersonnerepo.save(qcmPersonne1);
		
		
		
		Optional<QCMPersonne> qcmPersonne1Find = QCMPersonnerepo.findById(qcmPersonne1.getId());
		
		Assert.assertEquals(4 , qcmPersonne1Find.get().getNbTentative());

		
		int middleNumber = QCMPersonnerepo.findAll().size();
		Assert.assertEquals(1, (middleNumber - startNumber));
		
		QCMPersonnerepo.delete(qcmPersonne1);
		
		int finalNumber = QCMPersonnerepo.findAll().size();
		
		Assert.assertEquals(0, finalNumber - startNumber);
		
	
	}

}
