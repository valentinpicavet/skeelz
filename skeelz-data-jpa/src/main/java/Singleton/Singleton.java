package Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Singleton {
	
	private static Singleton instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("skeelz-tp");
	
	
	
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
}
