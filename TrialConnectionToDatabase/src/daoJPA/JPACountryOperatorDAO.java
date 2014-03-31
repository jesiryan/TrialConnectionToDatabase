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


import dao.CountryOperatorDAO;
import entities.CountryOperator;

@JPA
public class JPACountryOperatorDAO implements CountryOperatorDAO {

	@PersistenceContext(unitName="sprint2")
	private EntityManager em;
	
	@Override
	public void addCountryOperator(CountryOperator countryOperator) {
		Query query = em.createQuery("SELECT f FROM CountryOperator f");
		List<CountryOperator> countryOperators = query.getResultList(); 
		if (!countryOperators.contains(countryOperator))
			em.persist(countryOperator);
	}

	@Override
	public CountryOperator getCountryOperatorById(String id) {
		Query query  = em.createQuery("SELECT c FROM CountryOperator c WHERE c.id = :id");
		query.setParameter("id", id);
		List<CountryOperator> result = query.getResultList();
		return result.get(0);
	}
	
	@Override
	public List<CountryOperator> getCountryOperatorsByMCC(double mcc) {
		Query query  = em.createQuery("SELECT c FROM CountryOperator c WHERE c.mcc = :mcc");
		query.setParameter("mcc", mcc);
		List<CountryOperator> result = query.getResultList();
		return result;
	}
	
	@Override
	public List<CountryOperator> getCountryOperatorsByMNC(double mnc) {
		Query query  = em.createQuery("SELECT c FROM CountryOperator c WHERE c.mnc = :mnc");
		query.setParameter("mnc", mnc);
		List<CountryOperator> result = query.getResultList();
		return result;
	}
	
	@Override
	public List<CountryOperator> getCountryOperatorsByCountry(String country) {
		Query query  = em.createQuery("SELECT c FROM CountryOperator c WHERE c.country = :country");
		query.setParameter("country", country);
		List<CountryOperator> result = query.getResultList();
		return result;
	}
	
	@Override
	public List<CountryOperator> getCountryOperatorsByOperator(String operator) {
		Query query  = em.createQuery("SELECT c FROM CountryOperator c WHERE c.operator = :operator");
		query.setParameter("operator", operator);
		List<CountryOperator> result = query.getResultList();
		return result;
	}

	@Override
	public List<CountryOperator> getAllCountryOperators() {
		System.out.println("Got into JPACountryOperatorDAO getAllCountryOperators()");
		
		List<CountryOperator> countryOperators = null;
		Query query = em.createQuery("select c from CountryOperator c");
		countryOperators = query.getResultList(); 
		
		System.out.println("Size of countryOperators: " + countryOperators.size());
		
		if(countryOperators.size() == 0)
			return null;
		
		return countryOperators;
	}
	/*public List<CompactDisc> getAllDiscs() {
		Query query = em.createQuery("select distinct cd from CompactDisc cd left join fetch cd.trackTitles"); //join fetch cd.trackTitles");
		List<CompactDisc> discs = query.getResultList(); 
		System.out.println(discs.size());
		return discs;
	}*/
}
	