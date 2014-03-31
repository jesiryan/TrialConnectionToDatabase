package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the failureClass database table.
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
	@OneToMany(mappedBy="failureClass")
	private List<CallFailure> callFailures;

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

	public List<CallFailure> getCallFailures() {
		return this.callFailures;
	}

	public void setCallFailures(List<CallFailure> callFailures) {
		this.callFailures = callFailures;
	}

	public CallFailure addCallFailure(CallFailure callFailure) {
		getCallFailures().add(callFailure);
		callFailure.setFailureClass(this);

		return callFailure;
	}

	public CallFailure removeCallFailure(CallFailure callFailure) {
		getCallFailures().remove(callFailure);
		callFailure.setFailureClass(null);

		return callFailure;
	}

}