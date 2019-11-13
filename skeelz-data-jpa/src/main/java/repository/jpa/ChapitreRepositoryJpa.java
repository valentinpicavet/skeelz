package repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Singleton.Singleton;
import agence.voyage.singleton.Application;
import repository.IChapitreRepository;
import skeelz.modele.Chapitre;

public class ChapitreRepositoryJpa implements IChapitreRepository {

	@Override
	public List<Chapitre> findAll() {
		List<Chapitre> list = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			TypedQuery<Chapitre> query = em.createQuery("from Chapitre", Chapitre.class);
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
	public Chapitre find(Long id) {
		Chapitre obj = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			
			tx.begin();
			
			obj = em.find(Chapitre.class, id);
			
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
	public Chapitre save(Chapitre obj) {
		
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
	public void delete(Chapitre obj) {
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
