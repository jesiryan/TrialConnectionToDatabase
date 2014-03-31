package services;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.jws.WebService;

import entities.CountryOperator;

//@WebService
@Local
public interface CountryOperatorService {

    public List<CountryOperator> getCountryOperators() ;
    public void addToCountryOperators(CountryOperator countryOperator);
    
}
