package Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import repository.IEntrepriseRepository;
import repository.jpa.EntrepriseRepositoryJpa;


public class Singleton {
	
	private static Singleton instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("skeelz-tp");
	
	private final IEntrepriseRepository entrepriseRepo = new EntrepriseRepositoryJpa();
	
	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IEntrepriseRepository getEntrepriseRepo() {
		return entrepriseRepo;
	}
	
	
}
