package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the countryOperator database table.
 * 
 */
@Entity
@NamedQuery(name="CountryOperator.findAll", query="SELECT c FROM CountryOperator c")
public class CountryOperator implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CountryOperatorPK id;

	private String country;

	private String operator;

	//bi-directional many-to-one association to CallFailure
	@OneToMany(mappedBy="countryOperator")
	private List<CallFailure> callfailures;

	public CountryOperator() {
	}

	public CountryOperatorPK getId() {
		return this.id;
	}

	public void setId(CountryOperatorPK id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<CallFailure> getCallfailures() {
		return this.callfailures;
	}

	public void setCallfailures(List<CallFailure> callfailures) {
		this.callfailures = callfailures;
	}

	public CallFailure addCallfailure(CallFailure callfailure) {
		getCallfailures().add(callfailure);
		callfailure.setCountryOperator(this);

		return callfailure;
	}

	public CallFailure removeCallfailure(CallFailure callfailure) {
		getCallfailures().remove(callfailure);
		callfailure.setCountryOperator(null);

		return callfailure;
	}

}