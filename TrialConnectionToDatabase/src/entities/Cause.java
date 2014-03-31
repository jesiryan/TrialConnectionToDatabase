package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cause database table.
 * 
 */
@Entity
@NamedQuery(name="Cause.findAll", query="SELECT c FROM Cause c")
public class Cause implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CausePK id;

	private String description;

	//bi-directional many-to-one association to CallFailure
	@OneToMany(mappedBy="cause")
	private List<CallFailure> callFailures;

	public Cause() {
	}

	public CausePK getId() {
		return this.id;
	}

	public void setId(CausePK id) {
		this.id = id;
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
		callFailure.setCause(this);

		return callFailure;
	}

	public CallFailure removeCallFailure(CallFailure callFailure) {
		getCallFailures().remove(callFailure);
		callFailure.setCause(null);

		return callFailure;
	}

}