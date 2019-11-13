package test;

import java.util.List;

import Singleton.Singleton;

import repository.IElementDeCoursRepository;
import skeelz.modele.ElementDeCours;
import skeelz.modele.Paragraphe;



public class TestJpaElementDeCours {

	public static void main(String[] args) {
		IElementDeCoursRepository elementDeCoursRepo = Singleton.getInstance().getElementDeCoursRepo();

		int startNumber = elementDeCoursRepo.findAll().size();

		Paragraphe monElement = new Paragraphe();
		monElement.setAgencement(1);
		monElement.setTexte("bcejbvoebvouqbvlbqzjlvbzqou");
		monElement.setTitre("rjbvjebj");
		
		monElement = (Paragraphe) elementDeCoursRepo.save(monElement);


		ElementDeCours monElementFind = elementDeCoursRepo.find(monElement.getId());
		System.out.println(monElementFind);
		List<ElementDeCours> monElementFindList = elementDeCoursRepo.findAll();
		System.out.println(monElementFindList.get(0));



		
		int middleNumber = elementDeCoursRepo.findAll().size();
	
		System.out.println(middleNumber - startNumber);
		
		elementDeCoursRepo.delete(monElement);


	}

}
