package repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Singleton.Singleton;
import repository.IReponseRepository;
import skeelz.modele.Reponse;

public class ReponseRepositoryJpa implements IReponseRepository {
	
	@Override
	public List<Reponse> findAll() {
		List<Reponse> list = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			TypedQuery<Reponse> query = em.createQuery("from Reponse", Reponse.class);
			list = query.getResultList();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return list;
	}

	@Override
	public Reponse find(Long id) {
		Reponse obj = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			
			tx.begin();
			
			obj = em.find(Reponse.class, id);
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return obj;
	}

	@Override
	public Reponse save(Reponse obj) {
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			
			tx.begin();
			
			obj = em.merge(obj);
			tx.commit();
			
	}catch (Exception e) {
		e.printStackTrace();
		if (tx != null && tx.isActive()) {
			tx.rollback();
		}
	} finally {
		if (em != null) {
			em.close();
		}
	}
	return obj;
}

	@Override
	public void delete(Reponse obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			em.remove(em.merge(obj));

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	
}



