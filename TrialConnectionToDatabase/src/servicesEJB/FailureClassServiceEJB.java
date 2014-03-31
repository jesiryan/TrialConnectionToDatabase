package servicesEJB;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import dao.CountryOperatorDAO;
import dao.FailureClassDAO;
import daoJPA.JPA;
import entities.FailureClass;
import services.CountryOperatorService;
import services.FailureClassService;

@Stateless
//@WebService(endpointInterface="services.FailureClassService")
@Local(FailureClassService.class)
public class FailureClassServiceEJB implements FailureClassService {
	
	private FailureClassDAO dao;
	
	@Inject
	public void setDao(@JPA FailureClassDAO dao) {
		this.dao = dao;
	}
	
	public List<FailureClass> getFailureClasses() {
		System.out.println("Got into FailureClassServiceEJB getFailureClasses()");
		
		System.out.println("dao class: " + dao.getClass());
		
		List<FailureClass> failureClasses = dao.getAllFailureClasses();
		
		if(failureClasses == null){
			System.out.println("FailureClassServiceEJB getFailureClasses() is returning null");
			return null;
		}
		for(FailureClass fc : failureClasses){
			System.out.println(fc.getDescription());
		}
		System.out.println("FailureClassServiceEJB getFailureClasses() has something to return");
		return failureClasses;
	}
	
	public void addToFailureClasses(FailureClass failureClass) {
		if (!dao.getAllFailureClasses().contains(failureClass))
			dao.addFailureClass(failureClass);
	}
}