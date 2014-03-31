package daoJPA;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import dao.FailureClassDAO;
import entities.FailureClass;

@JPA
public class JPAFailureClassDAO implements FailureClassDAO {

	@PersistenceContext(unitName="sprint2")
	private EntityManager em;
	
	@Override
	public void addFailureClass(FailureClass failureClass) {
		Query query = em.createQuery("SELECT f FROM FailureClass f");
		List<FailureClass> failureClasses = query.getResultList(); 
		if (!failureClasses.contains(failureClass))
			em.persist(failureClass);
	}

	@Override
	public FailureClass getFailureClassById(String id) {
		Query query  = em.createQuery("SELECT f FROM FailureClass f WHERE f.id = :id");
		query.setParameter("id", id);
		List<FailureClass> result = query.getResultList();
		return result.get(0);
	}
	
	@Override
	public List<FailureClass> getFailureClassesByDescription(String description) {
		Query query  = em.createQuery("SELECT f FROM FailureClass f WHERE f.description = :description");
		query.setParameter("description", description);
		List<FailureClass> result = query.getResultList();
		return result;
	}

	@Override
	public List<FailureClass> getAllFailureClasses() {
		System.out.println("Got into JPAFailureClassDAO getAllFailureClasses()");
		
		List<FailureClass> failureClasses = null;
		
//		failureClasses = (List<FailureClass>) em.createNamedQuery("FailureClass.findAll").getResultList();
		Query query = em.createQuery("select f from FailureClass f ");
		failureClasses = query.getResultList(); 
		
		System.out.println("Size of failureClasses: " + failureClasses.size());
		
		if(failureClasses.size() == 0)
			return null;
		
		return failureClasses;
	}
	/*public List<CompactDisc> getAllDiscs() {
		Query query = em.createQuery("select distinct cd from CompactDisc cd left join fetch cd.trackTitles"); //join fetch cd.trackTitles");
		List<CompactDisc> discs = query.getResultList(); 
		System.out.println(discs.size());
		return discs;
	}*/
}
	