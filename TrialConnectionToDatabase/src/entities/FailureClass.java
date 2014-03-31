package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the failureclass database table.
 * 
 */
@Entity
@NamedQuery(name="FailureClass.findAll", query="SELECT f FROM FailureClass f")
public class FailureClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int failureClass;

	private String description;

	//bi-directional many-to-one association to CallFailure
	@OneToMany(mappedBy="failureclass")
	private List<CallFailure> callfailures;

	public FailureClass() {
	}

	public int getFailureClass() {
		return this.failureClass;
	}

	public void setFailureClass(int failureClass) {
		this.failureClass = failureClass;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CallFailure> getCallfailures() {
		return this.callfailures;
	}

	public void setCallfailures(List<CallFailure> callfailures) {
		this.callfailures = callfailures;
	}

	public CallFailure addCallfailure(CallFailure callfailure) {
		getCallfailures().add(callfailure);
		callfailure.setFailureclass(this);

		return callfailure;
	}

	public CallFailure removeCallfailure(CallFailure callfailure) {
		getCallfailures().remove(callfailure);
		callfailure.setFailureclass(null);

		return callfailure;
	}

}