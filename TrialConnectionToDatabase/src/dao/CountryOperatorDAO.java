package dao;

import java.util.List;
import java.util.Collection;

import entities.CountryOperator;

public interface CountryOperatorDAO {
	
	void addCountryOperator(CountryOperator countryOperator);
	CountryOperator getCountryOperatorById(String id);
	List<CountryOperator> getCountryOperatorsByMCC(double mcc);
	List<CountryOperator> getCountryOperatorsByMNC(double mnc);
	List<CountryOperator> getCountryOperatorsByCountry(String country);
	List<CountryOperator> getCountryOperatorsByOperator(String operator);
	List<CountryOperator> getAllCountryOperators();

}
