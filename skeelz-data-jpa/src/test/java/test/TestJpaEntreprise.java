package test;

import Singleton.Singleton;
import repository.IEntrepriseRepository;
import skeelz.modele.Entreprise;

public class TestJpaEntreprise {

	public static void main(String[] args) {
	IEntrepriseRepository entrepriseRepo = Singleton.getInstance().getEntrepriseRepo();
	
	int startNumber = entrepriseRepo.findAll().size();
	
	Entreprise sopra = new Entreprise();
	sopra.setNom("Sopra Steria");
	sopra.setNumeroSiret("ST0045");
	sopra.setTypeContrat("Contrat de ouf");
	
	sopra = entrepriseRepo.save(sopra);
	
	sopra = entrepriseRepo.find(sopra.getId());
	
	System.out.println(sopra.getNom());
	System.out.println(sopra.getNumeroSiret());
	System.out.println(sopra.getTypeContrat());
	
	int middleNumber = entrepriseRepo.findAll().size();
	
	System.out.println(middleNumber - startNumber);
	
	entrepriseRepo.delete(sopra);

	
	}
}
