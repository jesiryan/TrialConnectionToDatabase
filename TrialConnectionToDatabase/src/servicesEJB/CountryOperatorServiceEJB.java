package servicesEJB;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import dao.CountryOperatorDAO;
import daoJPA.JPA;
import entities.CountryOperator;
import services.CountryOperatorService;

@Stateless
//@WebService(endpointInterface="services.CountryOperatorService")
@Local(CountryOperatorService.class)
public class CountryOperatorServiceEJB implements CountryOperatorService {
	
	private CountryOperatorDAO dao;
	
	@Inject
	public void setDao(@JPA CountryOperatorDAO dao) {
		this.dao = dao;
	}
	
	public List<CountryOperator> getCountryOperators() {
		System.out.println("Got into CountryOperatorServiceEJB getCountryOperators()");
		
		List<CountryOperator> countryOperators = dao.getAllCountryOperators();
		
		if(countryOperators == null){
			System.out.println("CountryOperatorServiceEJB getCountryOperators() is returning null");
			return null;
		}
		for(CountryOperator co : countryOperators){
			System.out.println(co.getOperator());
		}
		System.out.println("CountryOperatorServiceEJB getCountryOperators() has something to return");
		return countryOperators;
	}
	
	public void addToCountryOperators(CountryOperator countryOperator) {
		if (!dao.getAllCountryOperators().contains(countryOperator))
			dao.addCountryOperator(countryOperator);
	}
}