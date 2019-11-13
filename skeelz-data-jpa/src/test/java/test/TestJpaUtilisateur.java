package test;

import Singleton.Singleton;
import repository.ISkeelzRepository;
import repository.IUtilisateurRepository;
import skeelz.modele.Skeelz;
import skeelz.modele.Utilisateur;

public class TestJpaUtilisateur {

	public static void main(String[] args) {
		
		IUtilisateurRepository userRepo = Singleton.getInstance().getUtilisateurRepo();
		
		int startNumber = userRepo.findAll().size();
		
		Utilisateur user = new Utilisateur();
		user.setIdentifiant("Damien");
		user.setMail("docteurnichons@yahoo.fr");
		user.setAdministrateur(false);
		user.setPassword("zboub");
		user.setRh(false);
		
		
		
		
		
		user = userRepo.save(user);
		
		
		
		user = userRepo.find(user.getId());
		
		System.out.println(user.getIdentifiant());
		
		int middleNumber = userRepo.findAll().size();
		System.out.println(middleNumber - startNumber);
		
		userRepo.delete(user);
		
	}

}
