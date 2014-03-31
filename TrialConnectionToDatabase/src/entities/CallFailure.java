package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the callfailure database table.
 * 
 */
@Entity
@NamedQuery(name="CallFailure.findAll", query="SELECT c FROM CallFailure c")
public class CallFailure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int baseDataID;

	private int cellId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	private int duration;

	private String hier3;

	private String hier32;

	private String hier321;

	private String iMSI;

	private String nEVersion;

	//bi-directional many-to-one association to FailureClass
	@ManyToOne
	private FailureClass failureclass;

	//bi-directional many-to-one association to CountryOperator
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="countryOperator_mCC", referencedColumnName="mCC"),
		@JoinColumn(name="countryOperator_mNC", referencedColumnName="mNC")
		})
	private CountryOperator countryoperator;

	//bi-directional many-to-one association to Equipment
	@ManyToOne
	private Equipment equipment;

	//bi-directional many-to-one association to Cause
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cause_causeCode", referencedColumnName="causeCode"),
		@JoinColumn(name="cause_eventId", referencedColumnName="eventId")
		})
	private Cause cause;

	public CallFailure() {
	}

	public int getBaseDataID() {
		return this.baseDataID;
	}

	public void setBaseDataID(int baseDataID) {
		this.baseDataID = baseDataID;
	}

	public int getCellId() {
		return this.cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getHier3() {
		return this.hier3;
	}

	public void setHier3(String hier3) {
		this.hier3 = hier3;
	}

	public String getHier32() {
		return this.hier32;
	}

	public void setHier32(String hier32) {
		this.hier32 = hier32;
	}

	public String getHier321() {
		return this.hier321;
	}

	public void setHier321(String hier321) {
		this.hier321 = hier321;
	}

	public String getIMSI() {
		return this.iMSI;
	}

	public void setIMSI(String iMSI) {
		this.iMSI = iMSI;
	}

	public String getNEVersion() {
		return this.nEVersion;
	}

	public void setNEVersion(String nEVersion) {
		this.nEVersion = nEVersion;
	}

	public FailureClass getFailureclass() {
		return this.failureclass;
	}

	public void setFailureclass(FailureClass failureclass) {
		this.failureclass = failureclass;
	}

	public CountryOperator getCountryoperator() {
		return this.countryoperator;
	}

	public void setCountryoperator(CountryOperator countryoperator) {
		this.countryoperator = countryoperator;
	}

	public Equipment getEquipment() {
		return this.equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Cause getCause() {
		return this.cause;
	}

	public void setCause(Cause cause) {
		this.cause = cause;
	}

}