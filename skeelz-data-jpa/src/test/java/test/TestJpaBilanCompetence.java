package test;

import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import repository.IBilanCompetenceRepository;
import skeelz.modele.BilanCompetence;


public class TestJpaBilanCompetence {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		IBilanCompetenceRepository bilanCompetenceRepo = context.getBean(IBilanCompetenceRepository.class);

		int startNumber = bilanCompetenceRepo.findAll().size();

		BilanCompetence monBilan = new BilanCompetence();
		
		monBilan = bilanCompetenceRepo.save(monBilan);


		Optional<BilanCompetence> monBilanFind = bilanCompetenceRepo.findById(monBilan.getId());
		System.out.println(monBilanFind);
		List<BilanCompetence> monBilanFindList = bilanCompetenceRepo.findAll();
		System.out.println(monBilanFindList.get(0));



		
		int middleNumber = bilanCompetenceRepo.findAll().size();
	
		System.out.println(middleNumber - startNumber);
		
		bilanCompetenceRepo.delete(monBilan);

		context.close();

	}

}
