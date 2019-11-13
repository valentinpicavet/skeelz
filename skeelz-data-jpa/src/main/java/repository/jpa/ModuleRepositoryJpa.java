package repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Singleton.Singleton;
import repository.IModuleRepository;
import skeelz.modele.Module;


public class ModuleRepositoryJpa implements IModuleRepository {

	@Override
	public List<Module> findAll() {
		List<Module> list = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			TypedQuery<Module> query = em.createQuery("from Module", Module.class);
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
	public Module find(Long id) {
		Module obj = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			
			tx.begin();
			
			obj = em.find(Module.class, id);
			
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
	public Module save(Module obj) {
		
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
	public void delete(Module obj) {
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
