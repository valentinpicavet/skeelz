package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpaRepo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("skeelz-tp");

	}

}
